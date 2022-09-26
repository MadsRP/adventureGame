package org.example;

public class room {

 int roomNumber;
 String connectingRooms;
 String description;

 public String getDescription(){
     return description;
 }
 public void setDescription(String description){
     this.description = description;
 }

 public int getRoomNumber(){
     return roomNumber;
 }
 public void setRoomNumber(int roomNumber){
     this.roomNumber = roomNumber;
 }

 public String getConnectingRooms(){
     return connectingRooms;
 }

 public void setConnectingRooms(String connectingRooms){
     this.connectingRooms = connectingRooms;
 }


}
