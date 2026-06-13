public class Park {
    private String name;

    public Park(String name){
        this.name = name;
    }

    public class Attraction{
        private String attraction;
        private String time;
        private int cost;

        public Attraction(String attraction, String time, int cost){
            this.attraction = attraction;
            this.time = time;
            this.cost = cost;
        }

        public void attractionInfo(){
            System.out.println("Название аттракциона: " + attraction + "; время работы: " + time + "; стоимость билета: " + cost);
        }
    }

}
