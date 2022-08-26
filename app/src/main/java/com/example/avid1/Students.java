
    package com.example.avid1;

    import java.util.Comparator;

    public class Students {
        private String Name;
        private Integer rank;
        private String Image_url;
        private String City;
        private String Type;
       // public String Type;

        public Students() {
        }

        public Students(String Name, Integer rank, String Image_url) {
            this.Name = Name;
            this.rank = rank;
            this.Image_url = Image_url;
            this.City=City;
            this.Type=Type;
        }
        public static Comparator<Students>StudentNameaz=new Comparator<Students>() {
            @Override
            public int compare(Students students, Students t1) {
                return students.getName().compareTo(t1.getName());
            }
        };

        public String getName() {
            return Name;
        }

        public Integer getRank() {

            //String rank1=String.valueOf(rank);
            return rank;
        }

        public String getCity(){
            return City;
        }


        public String getImage_url() {
            return Image_url;
        }

       public String getType() {
            return Type;
        }
    }


