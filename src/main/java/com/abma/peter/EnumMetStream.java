package com.abma.peter;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Random;
import java.util.stream.IntStream;

public class EnumMetStream {


    public static void main(String[] args) {



        //define stream
        IntStream streempje = new  Random().ints(100000L);
        // Print the stream
        long startTime = System.nanoTime();
        streempje
                //.sorted()
               .filter(s -> s > 0 && s<100000)
                .map(s-> s*10)
				//.peek(System.out::println)
                //.filter(s -> s < 1000)
                .sorted()
                .forEach(System.out::println);
        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("tijd " + totalTime);

/*		 System.out.println("1 Profile.P030: " + IntProfile.P030);
		 System.out.println("2 Profile.P030.name: " + Profile.P030.name());
		 System.out.println("4 find stream: " + Profile.findInStream("0000030"));
		 System.out.println("5 find loop: " + Profile.find("0000077"));*/
        //Profile z = new Profile("P999");
        //Profile p = Profile.P077;
        //Profile p = new Profle(
        //String p = Profile.valueOf("P077").profileNummerString;
        //String p = "0000077";
//		 System.out.println(p);
// 		switch (p) {
//			case Profile.P077.profileNummerString:
//                System.out.println("het profiel is P077 ! ");
//               break;
//            default:
//                System.out.println("default ");
//                break;
        //   }
    }
}
