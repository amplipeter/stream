package com.abma.peter;

import java.util.Arrays;

public class OldStatNewStatEnum {
	// -------------------------------------- start enum --------------------------------------------
     public  enum OldStatNewStat {
        PROD("PROD", "ACTIVATED"),
		TO_BE_ACT("INAC", "TO_BE_ACTIVATED");

        private final String oldStat;
        private final String newStat;
        //constructor
		OldStatNewStat(String oldStat, String newStat) {
			this.oldStat = oldStat;
			this.newStat = newStat;
		}
		//find string with for loop ---------------------------------------------------------------
		 private static OldStatNewStat find(String val) {
			 for (OldStatNewStat e : OldStatNewStat.values()) {
				 if (e.oldStat.equals(val)) {
					 return e;
				 }
			 }
			 throw new RuntimeException(String.format("Unsupported type %s.", val));
		 }
		//find string with for loop return new value---------------------------------------
		private static String findReturnNew(String val) {
			for (OldStatNewStat e : OldStatNewStat.values()) {
				if (e.oldStat.equals(val))
					return e.newStat;
			}
			throw new RuntimeException(String.format("Unsupported type %s.", val));
		}
		 //find string with stream ------------------------------------------------------------------
		 private static OldStatNewStat findInStream(String val) {
			 return Arrays.stream(OldStatNewStat.values())
					 .filter(e -> {
						 return e.oldStat.equals(val);
					 })
					 .findFirst()
					 .orElseThrow(() -> new RuntimeException(String.format("Unsupported type %s.", val)));
		 }


	 }
	 // -------------------------------------- end enum -----------------------------------------------

	 public static void main(String[] args) {
		 System.out.println("1 OldStatNewStat.PROD: " + OldStatNewStat.PROD);
		 System.out.println("2 OldStatNewStat.PROD.name: " + OldStatNewStat.PROD.name());
		 System.out.println("3 OldStatNewStat.PROD.oldStat: " + OldStatNewStat.PROD.oldStat);
		 System.out.println("4 OldStatNewStat.PROD.newStat: " + OldStatNewStat.PROD.newStat);

		 System.out.println("5 find stream: " + OldStatNewStat.findInStream("PROD"));
		 System.out.println("6 find loop: " + OldStatNewStat.find("PROD"));

		 System.out.println("7a find stream return new: " + OldStatNewStat.findInStream("PROD").newStat);
		 System.out.println("7b find stream return old: " + OldStatNewStat.findInStream("PROD").oldStat);
		 System.out.println("7c find stream return new: " + OldStatNewStat.findInStream("INAC").newStat);
		 System.out.println("7d find stream return old: " + OldStatNewStat.findInStream("INAC").oldStat);

		 System.out.println("8 find loop return new: " + OldStatNewStat.findReturnNew("PROD"));

   }
}
