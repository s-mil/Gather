package com.gather;

public class Message {
    public String sender;
    public String message;

//  public String chatPartnerId() {
//      FirebaseAuth auth = FirebaseAuth.getInstance();
//      if (auth.getCurrentUser().getUid() != null) {
//          if (fromId == toId)
//              return toId;
//          else
//              return fromId;
//      }
//  }

    public Message(String sender, String message) {
        this.sender = sender;
        this.message = message;
    }

    public String getSender() {
        return "SENDER";
    }
    public Message(){

    }
}
