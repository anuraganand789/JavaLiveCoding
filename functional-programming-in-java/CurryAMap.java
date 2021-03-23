import java.util.function.BiFunction;
import java.util.function.Consumer;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class CurryAMap{
    
    //Currying lambda I
    private final static BiFunction<Map<String, String>, String, Consumer<String>>
    curryAMap = (Map<String, String> map, String defaultValue) -> 
                ((Consumer<String>) (String columnValue)       -> map.put(columnValue, defaultValue));

    private final static BiFunction<Map<String, String>, String, Consumer<String>>
    curryAMapSmaller= (map, defaultValue) -> (columnValue) -> map.put(columnValue, defaultValue);


    public static void main(final String ...args){
        final List<String> 
              listOfColumnNames = List.of("FirstName", "LastName", "FatherName");
        final Map<String, String> 
              mapOfColumnAndValue = new HashMap<>();

        //Regular Way to do it.
        final String 
              defaultValue = "NA";

        for(final String columnName  : listOfColumnNames){
            mapOfColumnAndValue.put(columnName, defaultValue);
        }
        System.out.println("map for-loop " + mapOfColumnAndValue);

        putDefaultValue(mapOfColumnAndValue, listOfColumnNames, defaultValue);
        System.out.println("map func-call " + mapOfColumnAndValue);

        //Curried object
        final Consumer<String> 
              mapUpdate = curryAMapSmaller.apply(mapOfColumnAndValue, "FromLamda");

        consumeAList(listOfColumnNames, mapUpdate);
        System.out.println("map from lambda " + mapOfColumnAndValue);
    }
   
    static void putDefaultValue(final Map<String, String> map, 
                                final List<String> listOfColumns,
                                final String defaultValue){
       for(final String columnName  : listOfColumns){
           map.put(columnName, defaultValue);
       }
    }

    static void consumeAList( final List<String> listOfString,
                              final Consumer<String> mapUpdate){

        listOfString
        .stream()
        .forEach(mapUpdate::accept);
    }
}

