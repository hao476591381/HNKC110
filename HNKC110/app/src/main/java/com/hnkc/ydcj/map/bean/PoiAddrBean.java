package com.hnkc.ydcj.map.bean;

import java.io.Serializable;
import java.util.List;

public class PoiAddrBean {
    /**
     * status : 0
     * message : query ok
     * count : 331
     * request_id : 92f3eeb1b5641b9fc398b71e5b6a25d8
     * data : [{"id":"4066302879173685155","title":"长沙中电软件园","address":"湖南省长沙市岳麓区尖山路39号正附近","category":"房产小区:产业园区","location":{"lat":28.228247,"lng":112.880432},"ad_info":{"adcode":430104,"province":"湖南省","city":"长沙市","district":"岳麓区"},"_distance":0},{"id":"13380935684826134118","title":"羊驼教育","address":"湖南省长沙市岳麓区青山路长沙中电软件园9栋7楼","category":"教育学校:培训","location":{"lat":28.227777,"lng":112.880249},"ad_info":{"adcode":430104,"province":"湖南省","city":"长沙市","district":"岳麓区"},"_distance":55},{"id":"10316179150796553549","title":"长沙智造风能(新技术研究分院)","address":"湖南省长沙市岳麓区麓谷街道高新区尖山路","category":"机构团体:科研机构","location":{"lat":28.227723,"lng":112.880515},"ad_info":{"adcode":430104,"province":"湖南省","city":"长沙市","district":"岳麓区"},"_distance":58},{"id":"14298955214423834376","title":"长沙智造数控机床智能技术研究分院","address":"湖南省长沙市岳麓区岳麓大道北侧150米","category":"机构团体:科研机构","location":{"lat":28.227725,"lng":112.880508},"ad_info":{"adcode":430104,"province":"湖南省","city":"长沙市","district":"岳麓区"},"_distance":58},{"id":"3687186972803180483","title":"长沙智造高精密液压件研究分院","address":"湖南省长沙市岳麓区望安路附近","category":"机构团体:科研机构","location":{"lat":28.227723,"lng":112.880511},"ad_info":{"adcode":430104,"province":"湖南省","city":"长沙市","district":"岳麓区"},"_distance":58},{"id":"10713095350561066957","title":"长沙智造协作机器人联合实验室","address":"湖南省长沙市岳麓区岳麓大道附近","category":"机构团体:科研机构","location":{"lat":28.227725,"lng":112.880515},"ad_info":{"adcode":430104,"province":"湖南省","city":"长沙市","district":"岳麓区"},"_distance":58},{"id":"6646596052972754490","title":"长沙智造工业传感器研究分院","address":"湖南省长沙市岳麓区岳麓大道附近","category":"机构团体:科研机构","location":{"lat":28.227722,"lng":112.880516},"ad_info":{"adcode":430104,"province":"湖南省","city":"长沙市","district":"岳麓区"},"_distance":59},{"id":"8330875083170187313","title":"58到家(长沙总部)","address":"湖南省长沙市岳麓区欣盛路","category":"公司企业:公司企业","location":{"lat":28.228566,"lng":112.879571},"ad_info":{"adcode":430104,"province":"湖南省","city":"长沙市","district":"岳麓区"},"_distance":81},{"id":"12439546460597857299","title":"长沙开放实验室院士工作站","address":"湖南省长沙市岳麓区望安路与欣盛路交叉口东南100米","category":"机构团体:政府机关","location":{"lat":28.228625,"lng":112.879623},"ad_info":{"adcode":430104,"province":"湖南省","city":"长沙市","district":"岳麓区"},"_distance":89},{"id":"5175796851877250329","title":"艾特俱乐部(湖南)","address":"湖南省长沙市岳麓区欣盛路","category":"运动健身:其它运动健身","location":{"lat":28.229104,"lng":112.880439},"ad_info":{"adcode":430104,"province":"湖南省","city":"长沙市","district":"岳麓区"},"_distance":95}]
     */

    private int status;
    private String message;
    private int count;
    private String request_id;
    private List<DataBean> data;
    private List<?> sub_pois;

    public List<?> getSub_pois() {
        return sub_pois;
    }

    public void setSub_pois(List<?> sub_pois) {
        this.sub_pois = sub_pois;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getRequest_id() {
        return request_id;
    }

    public void setRequest_id(String request_id) {
        this.request_id = request_id;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "PoisAddrBean{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", count=" + count +
                ", request_id='" + request_id + '\'' +
                ", data=" + data +
                '}';
    }

    public static class DataBean implements Serializable {
        /**
         * id : 4066302879173685155
         * title : 长沙中电软件园
         * address : 湖南省长沙市岳麓区尖山路39号正附近
         * category : 房产小区:产业园区
         * location : {"lat":28.228247,"lng":112.880432}
         * ad_info : {"adcode":430104,"province":"湖南省","city":"长沙市","district":"岳麓区"}
         * _distance : 0
         */

        private String id;
        private String title;
        private String address;
        private String category;
        private LocationBean location;
        private AdInfoBean ad_info;
        private int _distance;
        private int type;
        private int adcode;
        private String province;
        private String city;
        private String district;

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getAdcode() {
            return adcode;
        }

        public void setAdcode(int adcode) {
            this.adcode = adcode;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getDistrict() {
            return district;
        }

        public void setDistrict(String district) {
            this.district = district;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public LocationBean getLocation() {
            return location;
        }

        public void setLocation(LocationBean location) {
            this.location = location;
        }

        public AdInfoBean getAd_info() {
            return ad_info;
        }

        public void setAd_info(AdInfoBean ad_info) {
            this.ad_info = ad_info;
        }

        public int get_distance() {
            return _distance;
        }

        public void set_distance(int _distance) {
            this._distance = _distance;
        }

        @Override
        public String toString() {
            return "DataBean{" +
                    "id='" + id + '\'' +
                    ", title='" + title + '\'' +
                    ", address='" + address + '\'' +
                    ", category='" + category + '\'' +
                    ", location=" + location +
                    ", ad_info=" + ad_info +
                    ", _distance=" + _distance +
                    '}';
        }

        public static class LocationBean {
            /**
             * lat : 28.228247
             * lng : 112.880432
             */

            private double lat;
            private double lng;

            public double getLat() {
                return lat;
            }

            public void setLat(double lat) {
                this.lat = lat;
            }

            public double getLng() {
                return lng;
            }

            public void setLng(double lng) {
                this.lng = lng;
            }

            @Override
            public String toString() {
                return "LocationBean{" +
                        "lat=" + lat +
                        ", lng=" + lng +
                        '}';
            }
        }

        public static class AdInfoBean {
            /**
             * adcode : 430104
             * province : 湖南省
             * city : 长沙市
             * district : 岳麓区
             */

            private int adcode;
            private String province;
            private String city;
            private String district;

            public int getAdcode() {
                return adcode;
            }

            public void setAdcode(int adcode) {
                this.adcode = adcode;
            }

            public String getProvince() {
                return province;
            }

            public void setProvince(String province) {
                this.province = province;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
                this.city = city;
            }

            public String getDistrict() {
                return district;
            }

            public void setDistrict(String district) {
                this.district = district;
            }

            @Override
            public String toString() {
                return "AdInfoBean{" +
                        "adcode=" + adcode +
                        ", province='" + province + '\'' +
                        ", city='" + city + '\'' +
                        ", district='" + district + '\'' +
                        '}';
            }
        }
    }
}
