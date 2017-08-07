/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
/**
 *
 * @author user
 */
public class GlyphGroup {
    
 public static final GlyphGroup NO_GROUP = new GlyphGroup ("NO_GROUP");
 public static final GlyphGroup UNSHIFTED_ALPHA = new GlyphGroup ("UNSHIFTED_ALPHA");
 public static final GlyphGroup SHIFTED_ALPHA = new GlyphGroup ("SHIFTED_ALPHA");
 public static final GlyphGroup NUMERIC = new GlyphGroup ("NUMERIC");
 public static final GlyphGroup FIGURES = new GlyphGroup ("FIGURES");
 public static final GlyphGroup BASIC = new GlyphGroup ("BASIC");
 
 private static Hashtable groups_by_name = new Hashtable();
 private static Vector groups = new Vector();
 
 static {
 groups.addElement(BASIC);
 groups.addElement(FIGURES);
 groups.addElement(NUMERIC);
 groups.addElement(SHIFTED_ALPHA);
 groups.addElement(UNSHIFTED_ALPHA);
 groups.addElement(NO_GROUP);
 
 groups_by_name.put("BASIC", BASIC);
 groups_by_name.put("FIGURES", FIGURES);
 groups_by_name.put("NUMERIC", NUMERIC);
 groups_by_name.put("SHIFTED_ALPHA", SHIFTED_ALPHA);
 groups_by_name.put("UNSHIFTED_ALPHA", UNSHIFTED_ALPHA);
 groups_by_name.put("NO_GROUP", NO_GROUP);
 }

public static Enumeration get_elements(){
return (groups.elements());
}

private String id;

public String get_resource_id(){
return ("GlyphGroup - " + id);
}

public String toString(){
return id;
}

private GlyphGroup (String id){
this.id = id;
} 

public static GlyphGroup find_glyphgroup (String name){
return((GlyphGroup)(groups_by_name.get(name)));
}
/*public static void main (String [] args){
System.out.println("**Class test code**");
for (Enumeration e = GlyphGroup.get_elements(); e.hasMoreElements();){
System.out.println(e.nextElement());
}
}*/
}