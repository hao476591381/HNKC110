package com.hnkc.ydcj.service.notify;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;

import androidx.annotation.RequiresApi;

import com.hnkc.ydcj.R;


public class NotifyUtil extends ContextWrapper {



    public NotifyUtil(Context context) {
        super(context);

    }


    @RequiresApi(api = Build.VERSION_CODES.N)
    public static  class Builder {
        private Context context;
        private  NotificationManager notifyManager;
        private String channelId;
        private String channelName;
        private int imporTance = NotificationManager.IMPORTANCE_HIGH;//通知重要性
        private Uri soundUri;
        private boolean isEnableLights = true;
        private boolean isEnableVibration = true;
        private long[] vibrateArray;
        private int smallIcon_id;
        private String contentText;
        private String contentTitle;
        private int notifyFlags;

        public Builder(Context context, String channelId, String channelName) {
            this.context = context;
            this.channelId = channelId;
            this.channelName = channelName;
            if (notifyManager == null) {
                notifyManager = (NotificationManager)context. getSystemService(Context.NOTIFICATION_SERVICE);
            }
        }

        @RequiresApi(api = Build.VERSION_CODES.O)
        private NotificationChannel getNotifyChannel(String channelId) {
            NotificationChannel notificationChannel = new NotificationChannel(this.channelId, channelName, imporTance);
            notificationChannel.enableLights(false);//是否在桌面icon右上角展示小圆点
            notificationChannel.setShowBadge(false); //是否在久按桌面图标时显示此渠道的通知
            notificationChannel.setSound(soundUri, Notification.AUDIO_ATTRIBUTES_DEFAULT);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.enableLights(isEnableLights);
            notificationChannel.enableVibration(isEnableVibration);
            return notificationChannel;
        }

        /**
         * 设置通知重要性
         *
         * @param imporTance
         */
        public Builder setImportance(int imporTance) {
            this.imporTance = imporTance;
            return this;
        }

        /**
         * 设置提示音
         *
         * @param soundName
         */
        public Builder setSound(String soundName) {
            this.soundUri = Uri.parse("android.resource://" + context.getPackageName() + "/raw/" + imporTance);
        return this;}

        /**
         * 是否开启闪灯
         *
         * @param isEnableLights
         * @return
         */
        public Builder IsEnableLights(boolean isEnableLights) {
            this.isEnableLights = isEnableLights;
            return this;
        }

        /**
         * 是否开启振动
         *
         * @param isEnableVibration
         * @return
         */
        public Builder IsEnableVibration(boolean isEnableVibration) {
            this.isEnableVibration = isEnableVibration;
            return this;
        }


        /**
         * 设置振动
         *
         * @param vibrateTag 标识 1 长 2 短 3.无
         * @return
         */
        public Builder setVibrate(int vibrateTag) {
            switch (vibrateTag) {
                case 1:
                    this.vibrateArray = new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400};
                case 2:
                    this.vibrateArray = new long[]{100, 200, 300};
                case 3:
                    this.vibrateArray = new long[]{0};
                default:
                    //通讯状态
            }
            return this;
        }

        /**
         * 设置图标
         *
         * @return
         */
        public Builder setSmallIcon(int smallIcon_id) {
            this.smallIcon_id = smallIcon_id;
            return this;
        }

        /**
         * 设置通知标题
         *
         * @param contentTitle
         * @return
         */
        public Builder setContentTitle(String contentTitle) {
            this.contentTitle = contentTitle;
            return this;
        }

        /**
         * 设置通知内容
         *
         * @param contentText
         * @return
         */
        public Builder setContentText(String contentText) {
            this.contentText = contentText;
            return this;
        }

        /**
         * 是否循环播放声音
         *
         * @param isCyclic
         */
        public Builder setNotifyFlags(boolean isCyclic) {
            if (isCyclic) {
                this.notifyFlags = Notification.FLAG_INSISTENT;
            } else {
                this.notifyFlags = Notification.DEFAULT_SOUND;
            }
            return this;
        }

        /**
         * 轮询消息
         *
         * @return
         */
        public Notification getPullNotification() {
            Notification.Builder builder;
            Notification notification;
            if (Build.VERSION.SDK_INT >= 26) {
                //Android O上对Notification进行了修改，如果设置的targetSDKVersion>=26建议使用此种方式创建通知栏
                if (!NotifyCofig.isCreateChannel) {
                    NotificationChannel notificationChannel = getNotifyChannel(channelId);
                    notifyManager.createNotificationChannel(notificationChannel);
                    NotifyCofig.isCreateChannel = true;
                }
                builder = new Notification.Builder(context, channelId);
            } else {
                builder = new Notification.Builder(context);
            }
            builder.setSmallIcon(R.drawable.heard)
                    .setContentTitle("通讯状态")
                    .setContentText("通讯正常")
                    .setVibrate(vibrateArray)//设置振动
                    .setSound(soundUri)
                    .setGroupSummary(false)
                    .setGroup("group")
                    .setOngoing(true)
                    .setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.drawable.heard))
                    .setWhen(System.currentTimeMillis());
            notification = builder.build();
            return notification;
        }


        /**
         * 接收到消息通知
         *
         * @param channelId
         * @return
         */
        private Notification getMsgNotification(String channelId) {
            Notification.Builder builder;
            Notification notification;
            if (Build.VERSION.SDK_INT >= 26) {
                //Android O上对Notification进行了修改，如果设置的targetSDKVersion>=26建议使用此种方式创建通知栏
                NotificationChannel notificationChannel = getNotifyChannel(channelId);
                notifyManager.createNotificationChannel(notificationChannel);
                builder = new Notification.Builder(context, channelId);
            } else {
                builder = new Notification.Builder(context);
            }
            builder.setSmallIcon(smallIcon_id)
                    .setContentTitle(contentTitle)
                    .setContentText(contentText)
                    .setVibrate(vibrateArray)//设置振动
                    .setSound(soundUri)
                    .setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.drawable.heard))
                    .setWhen(System.currentTimeMillis())
                    .setGroupSummary(false)
                    .setGroup("group")
                    .setAutoCancel(true);// 点击以后让通知消失
            //setContentIntent(builder, channelId);
            notification = builder.build();
            return notification;
        }

        /**
         * 发送消息通知
         */
        public void SendNotify() {
       /* String mChannelId = getChannelId();
        if (!mChannelId.equals(channelId)) {
            setChannelId(channelId);
            Notification notification = getMsgNotification(channelId);
            getNotifyManager().notify(NOTIFY_MSG_TYPE, notification);
        }*/
            Notification notification = getMsgNotification(channelId);
            notification.flags |= notifyFlags;  //循环播放声音
            notifyManager.notify(NotifyCofig.NOTIFY_MSG_TYPE, notification);
        }

    }
}
