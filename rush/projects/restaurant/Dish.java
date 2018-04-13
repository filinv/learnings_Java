public enum Dish {
    Fish, Steak, Soup, Juice, Water;
    /**сформирует строку из всех блюд */
    public static String allDishesToString(){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<Dish.values().length;i++){
            sb.append(Dish.values()[i]);
            if(i!=Dish.values().length-1)sb.append(", ");
        }
        return sb.toString();
    }
}
