package networkCore.packageObj;

//import userInfo.*;


import java.io.*;

public class packageObj implements Serializable
{
   private packageType type; 
   private Object obj;
  // private userInfo user;
   
   private packageObj(){}
   public packageObj(packageType newType){type = newType;}

   public void setType(packageType newType){
	type = newType;
   }
   
   public packageType getType(){return type;}

   public void setObj(Object newobj){obj = newobj;}
   public Object getObj(){return obj;}


}
