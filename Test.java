package Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Room{
    String id;
    int floorNumber;
  int roomNumber;
  int capacity;
  List<String> meetingSlots;


}
public class Test {
    List<Room> rooms = new ArrayList<>();
    int minFloor = 7;
    int maxFloor =9;
    Test(){
        Room r1 = new Room();
        r1.id="7.11";
        r1.floorNumber=7;
        r1.roomNumber = 11;
        r1.capacity = 8;
        List<String> slots1 = Arrays.asList(new String[]{"9:00-9:15","14:30-15:00"});
        r1.meetingSlots = slots1;
        rooms.add(r1);

        Room r2 = new Room();
        r2.id = "8.23";
        r2 .floorNumber=8;
        r2 .roomNumber = 23;
        r2.capacity = 6;
        List<String> slots2 = Arrays.asList(new String[]{"10:00-11:00","14:00-15:00"});
        r2 .meetingSlots = slots2;
        rooms.add(r2);

        Room r3 = new Room();
        r3.id = "8.43";
        r3 .floorNumber=8;
        r3 .roomNumber = 43;
        r3.capacity = 7;
        List<String> slots3 = Arrays.asList(new String[]{"11:30-12:30","17:00-17:30"});
        r3 .meetingSlots = slots3;
        rooms.add(r3);

        Room r4 = new Room();
        r4.id="9.511";
        r4 .floorNumber=9;
        r4 .roomNumber = 511;
        r4.capacity = 9;
        List<String> slots4 = Arrays.asList(new String[]{"9:30-10:30","12:00-12:15","15:15-16:15"});
        r4 .meetingSlots = slots4;
        rooms.add(r4);

        Room r5 = new Room();
        r5.id = "9.527";
        r5 .floorNumber=9;
        r5.roomNumber = 527;
        r5.capacity = 4;
        List<String> slots5 = Arrays.asList(new String[]{"9:00-11:00","14:00-16:00"});
        r5 .meetingSlots = slots5;
        rooms.add(r5);

        Room r6 = new Room();
        r6.id="9.547";
        r6 .floorNumber=9;
        r6.roomNumber = 547;
        r6.capacity = 8;
        List<String> slots6 = Arrays.asList(new String[]{"10:30-11:30","13:30-15:30","16:30-17:30"});
        r6 .meetingSlots = slots6;
        rooms.add(r6);




    }

    public String roomNumber(Integer capacity,Integer floor,String startTime,String endTime){

        String slot = startTime+"-"+endTime;
        //System.out.println(slot);
        // List<Room> reqRooms = new ArrayList<Room>();
       for(int i=0;i<rooms.size();i++){
           if(rooms.get(i).id.indexOf(floor.toString())==0 && rooms.get(i).capacity>=capacity){
               List<String> list = rooms.get(i).meetingSlots;
               if(list.contains(slot)){
                //    System.out.println("inside first floor");
                   return rooms.get(i).id;
               }
           }
       }


            for(int j=floor+1;j<=maxFloor;j++){
                Integer num = j;
                for(int k=0;k<rooms.size();k++){
                    if(rooms.get(k).id.indexOf(num.toString())==0 && rooms.get(k).capacity>=capacity){
                        List<String> list1 = rooms.get(k).meetingSlots;
                        if(list1.contains(slot)){
                            System.out.println("inside second floor");
                            return rooms.get(k).id;
                        }
                    }
                }
            }


            for(int j=floor-1;j>=minFloor;j--){
                Integer num = j;
                for(int k=0;k<rooms.size();k++){
                    if(rooms.get(k).id.indexOf(num.toString())==0 && rooms.get(k).capacity>=capacity){
                        List<String> list2 = rooms.get(k).meetingSlots;
                        if(list2.contains(slot)){
                            System.out.println("inside third floor");
                            return rooms.get(k).id;
                        }
                    }
                }
            }



        return "no rooms found";
    }

    public static void main(String[] args) {

        Test obj = new Test();

        String roomIdNumber = obj.roomNumber(8,7,"9:00","9:15");
        System.out.println(roomIdNumber);
        String roomIdNumber2 = obj.roomNumber(5,8,"10:30","11:30");
        System.out.println(roomIdNumber2);

        String roomIdNumber3 = obj.roomNumber(5,8,"18:30","19:30");
        System.out.println(roomIdNumber3);



    }

}
