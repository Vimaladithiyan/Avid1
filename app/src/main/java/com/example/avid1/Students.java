
    package com.example.avid1;

    public class Students {
        private String Name;
        private Integer rank;
        private String imageurl;
        public Students() {
        }

        public Students(String Name, Integer rank, String imageurl) {
            this.Name = Name;
            this.rank = rank;
            this.imageurl = imageurl;
        }

        public String getName() {
            return Name;
        }

        public Integer getRank() {

            //String rank1=String.valueOf(rank);
            return rank;
        }

        //public String getImageurl() {

            //return imageurl;
        //}

    }


