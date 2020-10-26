package com.hg.lib.tool;

import android.widget.ImageView;

import com.hg.lib.R;

import org.xutils.common.util.DensityUtil;
import org.xutils.image.ImageOptions;
import org.xutils.x;

public class ImgBindTool {

    public static void imgBind(ImageView imageView, String imgPath) {
        x.image().bind(imageView, imgPath, imageOptions());
    }

    private static ImageOptions imageOptions() {
        return new ImageOptions.Builder()
                // .setSize(DensityUtil.dip2px(120), DensityUtil.dip2px(120))
                //  .setRadius(DensityUtil.dip2px(10))
                // 如果ImageView的大小不是定义为wrap_content, 不要crop.
                .setCrop(true)
                // 加载中或错误图片的ScaleType
                // .setPlaceholderScaleType(ImageView.ScaleType.MATRIX)
                .setImageScaleType(ImageView.ScaleType.CENTER_CROP)
                // 设置加载过程中的图片
                .setLoadingDrawableId(R.drawable.user_head_icon)
                // 设置加载失败后的图片
                .setFailureDrawableId(R.drawable.user_head_icon)
                // 设置使用缓存
                .setUseMemCache(true)
                // 设置支持gif
                .setIgnoreGif(false)
                // 设置显示圆形图片
                .setCircular(true).setSquare(false).build();
    }

    /**
     * 首页模块图标绑定
     * @param imageView
     * @param path
     */
    public static void ModuleImgBind(ImageView imageView,String path) {
        x.image().bind(imageView, path, new ImageOptions.Builder()
             //   .setSize(DensityUtil.dip2px(120), DensityUtil.dip2px(120))
                .setRadius(DensityUtil.dip2px(5))
                // 如果ImageView的大小不是定义为wrap_content, 不要crop.
                .setCrop(true)
                // 加载中或错误图片的ScaleType
                // .setPlaceholderScaleType(ImageView.ScaleType.MATRIX)
                .setImageScaleType(ImageView.ScaleType.CENTER_CROP)
                // 设置加载过程中的图片
                .setLoadingDrawableId(R.drawable.album_image_placeholder)
                // 设置加载失败后的图片
                .setFailureDrawableId(R.drawable.album_image_placeholder)
                // 设置使用缓存
                .setUseMemCache(true)
                // 设置支持gif
                .setIgnoreGif(false)
                // 设置显示圆形图片
                .setCircular(false).setSquare(false).build());
    }
}
