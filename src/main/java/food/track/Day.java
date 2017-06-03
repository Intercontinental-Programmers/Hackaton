package food.track;

import javafx.util.Pair;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by okkindel on 03.06.17.
 */
public class Day {
    private String breakfast;
    private String dinner;
    private String supper;
    private String desc_breakfast;
    private String desc_dinner;
    private String desc_supper;
    private String img_breakfast;
    private String img_dinner;
    private String img_supper;
    private ArrayList<String> ingredients_breakfast = new ArrayList<>();
    private ArrayList<String> ingredients_dinner = new ArrayList<>();
    private ArrayList<String> ingredients_supper = new ArrayList<>();
    private ArrayList< Pair<Integer,Integer> > tobuylist = new ArrayList<>();

    Day(int id, int d) {
        String connectionUrl = "jdbc:sqlserver://foodtrack.database.windows.net:1433;database=FoodTrack;user=notroot@foodtrack;password=adihajmaktre+69";

        // Declare the JDBC objects.
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Establish the connection.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(connectionUrl);

            // Create and execute an SQL statement that returns some data.
            String SQL = "SELECT id_dishes FROM dishforuser WHERE id_users = "+id+" AND day = "+d;
            stmt = con.createStatement();
            rs = stmt.executeQuery(SQL);

            // Iterate through the data in the result set and display it.
            rs.next();
            SQL = "SELECT * FROM dishes WHERE id_dishes = "+rs.getString(1);
            stmt = con.createStatement();
            ResultSet dishes = stmt.executeQuery(SQL);
            dishes.next();
            breakfast = dishes.getString(2);
            desc_breakfast = dishes.getString(3);
            img_breakfast = dishes.getString(5);

            SQL = "SELECT id_ingredients, quantity FROM dishingredients WHERE id_dishes = "+rs.getString(1);
            stmt = con.createStatement();
            ResultSet ingredients = stmt.executeQuery(SQL);
            while (ingredients.next()) {
                boolean guard = true;
                Pair<Integer, Integer> para = new Pair<Integer, Integer>(ingredients.getInt(1), ingredients.getInt(2));
                for (Pair<Integer, Integer> integerIntegerPair : tobuylist) {
                    if(integerIntegerPair.getKey().equals(para.getKey())) {
                        int index = tobuylist.indexOf(integerIntegerPair);
                        tobuylist.set(index, new Pair<>(para.getKey(), integerIntegerPair.getValue()+para.getValue()));
                        guard = false;
                        break;
                    }
                }
                if(guard) {
                    tobuylist.add(para);
                }

                SQL = "SELECT name FROM ingredients WHERE id_ingredients = "+ingredients.getString(1);
                stmt = con.createStatement();
                ResultSet ingredient_names = stmt.executeQuery(SQL);
                while (ingredient_names.next()) {
                    ingredients_breakfast.add(ingredient_names.getString(1));
                }
            }


            rs.next();
            SQL = "SELECT * FROM dishes WHERE id_dishes = "+rs.getString(1);
            stmt = con.createStatement();
            dishes = stmt.executeQuery(SQL);
            dishes.next();
            dinner = dishes.getString(2);
            desc_dinner = dishes.getString(3);
            img_dinner = dishes.getString(5);

            SQL = "SELECT id_ingredients, quantity FROM dishingredients WHERE id_dishes = "+rs.getString(1);
            stmt = con.createStatement();
            ingredients = stmt.executeQuery(SQL);
            while (ingredients.next()) {
                boolean guard = true;
                Pair<Integer, Integer> para = new Pair<Integer, Integer>(ingredients.getInt(1), ingredients.getInt(2));
                for (Pair<Integer, Integer> integerIntegerPair : tobuylist) {
                    if(integerIntegerPair.getKey().equals(para.getKey())) {
                        int index = tobuylist.indexOf(integerIntegerPair);
                        tobuylist.set(index, new Pair<>(para.getKey(), integerIntegerPair.getValue()+para.getValue()));
                        guard = false;
                        break;
                    }
                }
                if(guard) {
                    tobuylist.add(para);
                }

                SQL = "SELECT name FROM ingredients WHERE id_ingredients = "+ingredients.getString(1);
                stmt = con.createStatement();
                ResultSet ingredient_names = stmt.executeQuery(SQL);
                while (ingredient_names.next()) {
                    ingredients_dinner.add(ingredient_names.getString(1));
                }
            }

            rs.next();
            SQL = "SELECT * FROM dishes WHERE id_dishes = "+rs.getString(1);
            stmt = con.createStatement();
            dishes = stmt.executeQuery(SQL);
            dishes.next();
            supper = dishes.getString(2);
            desc_supper = dishes.getString(3);
            img_supper = dishes.getString(5);

            SQL = "SELECT id_ingredients, quantity FROM dishingredients WHERE id_dishes = "+rs.getString(1);
            stmt = con.createStatement();
            ingredients = stmt.executeQuery(SQL);
            while (ingredients.next()) {
                boolean guard = true;
                Pair<Integer, Integer> para = new Pair<Integer, Integer>(ingredients.getInt(1), ingredients.getInt(2));
                for (Pair<Integer, Integer> integerIntegerPair : tobuylist) {
                    if(integerIntegerPair.getKey().equals(para.getKey())) {
                        int index = tobuylist.indexOf(integerIntegerPair);
                        tobuylist.set(index, new Pair<>(para.getKey(), integerIntegerPair.getValue()+para.getValue()));
                        guard = false;
                        break;
                    }
                }
                if(guard) {
                    tobuylist.add(para);
                }

                SQL = "SELECT name FROM ingredients WHERE id_ingredients = "+ingredients.getString(1);
                stmt = con.createStatement();
                ResultSet ingredient_names = stmt.executeQuery(SQL);
                while (ingredient_names.next()) {
                    ingredients_supper.add(ingredient_names.getString(1));
                }
            }


        }

        // Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (rs != null) try { rs.close(); } catch(Exception e) {}
            if (stmt != null) try { stmt.close(); } catch(Exception e) {}
            if (con != null) try { con.close(); } catch(Exception e) {}
        }
    }

    public String getImg_breakfast() {
        return img_breakfast;
    }

    public void setImg_breakfast(String img_breakfast) {
        this.img_breakfast = img_breakfast;
    }

    public String getImg_dinner() {
        return img_dinner;
    }

    public void setImg_dinner(String img_dinner) {
        this.img_dinner = img_dinner;
    }

    public String getImg_supper() {
        return img_supper;
    }

    public void setImg_supper(String img_supper) {
        this.img_supper = img_supper;
    }
    public String getNameByIndex(int id){
        if (id == 1)  return "Ryz";
        if (id == 2)  return "Mieso z kurczaka";
        if (id == 3)  return "Marchew";
        if (id == 4)  return "Pomidor";
        if (id == 5)  return "Cebula";
        if (id == 6)  return "Tofu";
        if (id == 7)  return "Jajka";
        if (id == 8)  return "Chleb";
        if (id == 9)  return "Platki owsiane";
        if (id == 10)  return "Mleko";
        if (id == 11)  return "Jogurt";
        if (id == 12)  return "Ogorek zielony";
        if (id == 13)  return "Ser bialy";
        if (id == 14)  return "Ziemniaki";
        if (id == 15)  return "Papryka";
        if (id == 16)  return "Smietana 18%";
        if (id == 17)  return "Makaron";
        if (id == 18)  return "Kasza gryczana";
        if (id == 19)  return "Wolowina";
        if (id == 20)  return "Mieso z indyka";
        if (id == 21)  return "Mieso mielone z indyka";
        if (id == 22)  return "Bulion z rosolu";
        if (id == 23)  return "Wloszczyzna";
        if (id == 24)  return "Ser";
        else return "";



    }

    public String getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(String breakfast) {
        this.breakfast = breakfast;
    }

    public String getDinner() {
        return dinner;
    }

    public void setDinner(String dinner) {
        this.dinner = dinner;
    }

    public String getSupper() {
        return supper;
    }

    public void setSupper(String supper) {
        this.supper = supper;
    }

    public String getDesc_breakfast() {
        return desc_breakfast;
    }

    public void setDesc_breakfast(String desc_breakfast) {
        this.desc_breakfast = desc_breakfast;
    }

    public String getDesc_dinner() {
        return desc_dinner;
    }

    public void setDesc_dinner(String desc_dinner) {
        this.desc_dinner = desc_dinner;
    }

    public String getDesc_supper() {
        return desc_supper;
    }

    public void setDesc_supper(String desc_supper) {
        this.desc_supper = desc_supper;
    }

    public ArrayList<String> getIngredients_breakfast() {
        return ingredients_breakfast;
    }

    public void setIngredients_breakfast(ArrayList<String> ingredients_breakfast) {
        this.ingredients_breakfast = ingredients_breakfast;
    }

    public ArrayList<String> getIngredients_dinner() {
        return ingredients_dinner;
    }

    public void setIngredients_dinner(ArrayList<String> ingredients_dinner) {
        this.ingredients_dinner = ingredients_dinner;
    }

    public ArrayList<String> getIngredients_supper() {
        return ingredients_supper;
    }

    public void setIngredients_supper(ArrayList<String> ingredients_supper) {
        this.ingredients_supper = ingredients_supper;
    }

    public ArrayList<Pair<String, Integer>> getTobuylist() {
        ArrayList< Pair<String, Integer> > result = new ArrayList<>();
        for (int i = 0; i < tobuylist.size(); i++) {
            result.add(new Pair<String, Integer>(getNameByIndex(tobuylist.get(i).getKey()), tobuylist.get(i).getValue()));
        }
        return result;
    }

    public void setTobuylist(ArrayList<Pair<Integer, Integer>> tobuylist) {
        this.tobuylist = tobuylist;
    }

    @Override
    public String toString() {
        System.out.print(getTobuylist());
        return "Day{" +
                "breakfast='" + breakfast + '\'' +
                ", dinner='" + dinner + '\'' +
                ", supper='" + supper + '\'' +
                ", desc_breakfast='" + desc_breakfast + '\'' +
                ", desc_dinner='" + desc_dinner + '\'' +
                ", desc_supper='" + desc_supper + '\'' +
                ", img_breakfast='" + img_breakfast + '\'' +
                ", img_dinner='" + img_dinner + '\'' +
                ", img_supper='" + img_supper + '\'' +
                ", ingredients_breakfast=" + ingredients_breakfast +
                ", ingredients_dinner=" + ingredients_dinner +
                ", ingredients_supper=" + ingredients_supper +
                ", tobuylist=" + tobuylist +
                '}';
    }
}
