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
public class KeyShiftState {
    private String id;
    
    public final static KeyShiftState UNSHIFTED = new KeyShiftState ("UNSHIFTED");
    public final static KeyShiftState SHIFTED = new KeyShiftState ("SHIFTED");
    public final static KeyShiftState META_ALT = new KeyShiftState ("META_ALT");
    
    private static Hashtable states_by_name = new Hashtable ();
    
    static {
    states_by_name.put("SHIFTED", SHIFTED);
    states_by_name.put("UN0HIFTED", UNSHIFTED);
    states_by_name.put("META_ALT", META_ALT);
    }
    
    public KeyShiftState (String id){
    this.id = id;
    }
    
    public static KeyShiftState find_keyshiftstate (String name){
    return ((KeyShiftState)(states_by_name.get(name)));
    }
    public String toString(){
    return id;
    }
}
