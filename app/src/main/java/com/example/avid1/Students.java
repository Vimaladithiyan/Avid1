
    package com.example.avid1;

    public class Students {
        private String Name;
        private Integer rank;

        public Students() {
        }

        public Students(String Name, Integer rank) {
            this.Name = Name;
            this.rank = rank;
        }

        public String getName() {
            return Name;
        }

        public String getRank() {

            String rank1=String.valueOf(rank);
            return rank1;
        }
    }


