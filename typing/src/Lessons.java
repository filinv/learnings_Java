/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class Lessons {
    private final String title;
    private final String instructions;
    private final String text;
    
    public Lessons (String title, String instructions, String text){
    this.title = title;
    this.instructions = instructions;
    this.text = text;
    }   
    public String get_title (){
    if(title !=null) return title;
    else return "Title";
    }
    public String get_instructions (){
    if(instructions !=null) return instructions;
    else return "Instructions";
    }
    public String get_text (){
    if(text !=null) return text;
    else return "Text";
    }
}
