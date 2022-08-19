
    package com.example.avid1;

    public class Students {
        private String Name;
        private Integer rank;
        private String Image_url;
        private String City;
        public Students() {
        }

        public Students(String Name, Integer rank, String imageurl) {
            this.Name = Name;
            this.rank = rank;
            this.Image_url = Image_url;
            this.City=City;
        }

        public String getName() {
            return Name;
        }

        public Integer getRank() {

            //String rank1=String.valueOf(rank);
            return rank;
        }



        public String getImage_url() {
            return Image_url;
        }
    }


