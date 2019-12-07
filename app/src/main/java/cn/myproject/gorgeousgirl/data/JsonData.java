package cn.myproject.gorgeousgirl.data;

import java.util.List;

public class JsonData {

    /**
     * code : 1
     * msg : 数据返回成功
     * data : [{"imageUrl":"https://tvax4.sinaimg.cn/large/005BYqpgly1g1utaukq1nj31c00u00wc.jpg","imageSize":"1728x1080","imageFileLength":134209},{"imageUrl":"https://tvax4.sinaimg.cn/large/005BYqpggy1g1utbck4nqj31c00u0n1d.jpg","imageSize":"1728x1080","imageFileLength":149386},{"imageUrl":"https://tvax2.sinaimg.cn/large/005BYqpggy1g1uqfpatiyj31hc0u0ah2.jpg","imageSize":"1920x1080","imageFileLength":145914},{"imageUrl":"https://tvax2.sinaimg.cn/large/005BYqpgly1g1ursgvyadj31c00u0gxb.jpg","imageSize":"1728x1080","imageFileLength":106867},{"imageUrl":"http://ww4.sinaimg.cn/large/610dc034jw1fbffqo6jjoj20u011hgpx.jpg","imageSize":"1080x1349","imageFileLength":169434},{"imageUrl":"http://ww1.sinaimg.cn/large/610dc034jw1f5hpzuy3r7j20np0zkgpd.jpg","imageSize":"853x1280","imageFileLength":149002},{"imageUrl":"http://ww1.sinaimg.cn/large/7a8aed7bjw1ezzaw04857j20p00gp40w.jpg","imageSize":"900x601","imageFileLength":98417},{"imageUrl":"http://ww3.sinaimg.cn/large/7a8aed7bgw1etlw75so1hj20qo0hsgpk.jpg","imageSize":"960x640","imageFileLength":156136},{"imageUrl":"http://ww2.sinaimg.cn/large/7a8aed7bjw1eucg4wdq8ij20m80m8q6s.jpg","imageSize":"800x800","imageFileLength":152303},{"imageUrl":"http://ww1.sinaimg.cn/large/7a8aed7bgw1euzko6672oj20go0oz771.jpg","imageSize":"600x899","imageFileLength":111817}]
     */

    private int code;
    private String msg;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public List<DataBean> getData() {
        return data;
    }

    public static class DataBean {
        /**
         * imageUrl : https://tvax4.sinaimg.cn/large/005BYqpgly1g1utaukq1nj31c00u00wc.jpg
         * imageSize : 1728x1080
         * imageFileLength : 134209
         */

        private String imageUrl;
        private String imageSize;
        private int imageFileLength;

        public String getImageUrl() {
            return imageUrl;
        }

        public String getImageSize() {
            return imageSize;
        }

        public int getImageFileLength() {
            return imageFileLength;
        }
    }
}
