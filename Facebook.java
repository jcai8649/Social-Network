import java.util.*;
/*
* Submitting from Jackson ZhenCheng Cai
* This program was created in collaboration with Bill Feng.
* For CS 146
* 12/09/2019
*/
public class Facebook {
  // Define the class to hold all the users
  static class Network {
    
  // A list of all the users
  ArrayList<Account> userList = new ArrayList<Account>();
    
  /**
  ** @param user Object from Account
  ** Add/create user into the Facebook network
  **/
  public void add(Account user) {
    userList.add(user);
  }

  /**
  ** @param user Object from Account
  ** Delete a user profile from the network
  **/
  public void remove(Account user) {
    userList.remove(user);
  }

  /**
  ** @param user name to be search for in the network
  ** Search for a person name in the network
  ** Print out user profile
  **/
  public void search(String name) {
    for (int i = 0; i < userList.size(); i++) {
      if(userList.get(i).name == name) {
        System.out.println("Search Results:");
        printProfile(userList.get(i));
      }
       else
         System.out.println("No search results for " + name);
         break;
      }
    }

  /**
  ** @param Object Account - person
  ** Print all user profile info
  ** Person Name
  ** Person status
  ** Person Image link
  **/
  public void printProfile(Account person) {
    System.out.println("Name: " + person.name + "\nStatus: " + person.status +
    "\nImageLink: " + person.image);
  }

  //Add friend A to friend B
  //Add friend B to friend A
  //call add method in Account to add friend
  public void addFriend(Account source, Account dest) {
    source.add(dest);
    dest.add(source);
   =}
 }

  // A class to represent the profile of a person
  static class Account {
    String name;
    String status;
    String image;
  
    // Contain a list of friends
    Map<String, LinkedList<String>> friendMap;

    // constructor for an account
    public Account(String name, String status, String image) {
      this.name = name;
      this.status = status;
      this.image = image;

      friendMap = new HashMap<String, LinkedList<String>>();
    }

    /**
    **
    ** Print out friend list of the current person.
    **/
    public void showFriends() {
      Set<String> set = friendMap.keySet();
      Iterator<String> iterator = set.iterator();

      if (!(iterator.hasNext())) {
        System.out.print("No Friends :(");
        System.out.print("\n------------------------------------\n");
      }

      while (iterator.hasNext()) {
        Object vertex = iterator.next();
        System.out.print("Friends: ");
        LinkedList<String> list = friendMap.get(vertex);
        for (int i = 0; i < list.size(); i++) {
          System.out.print(list.get(i) + ", ");
        }
        System.out.print("\n------------------------------------");
        System.out.println();
      }
    }


    /**
    ** @param A friend to be added Account Object
    ** Add friend A to friend B
    **/
    public void add(Account dest) {
      if (friendMap.get(this.name) == null) {
        friendMap.put(this.name, new LinkedList<String>());
      }
      friendMap.get(this.name).addFirst(dest.name);
    }


    /**
    ** @param new name
    ** Upload current name to new name
    **/
    public void modifyName(String name) {
      String oldName = this.name;
      this.name = name;
      System.out.print("\n"+ oldName + ", your new name is: " + this.name);
    }

    /**
    ** @param new status
    ** Upload current status to new status
    **/
    public void modifyStatus(String status) {
      this.status = status;
      System.out.print("\n Your new status is: " + this.status);
    }

    /**
    ** @param new image link
    ** Upload current image link to new image link
    **/
    public void modifyImage(String image) {
      this.image = image;
      System.out.print("\n Your new image is: " + this.image);
    }
  }

  public static void main(String[] args) {
    Network fb = new Network();
    Account mike = new Account("Mike", "Mike status", "https://bit.ly/2sbZDdi");
    Account mel = new Account("Mel", "OMG, look at that", "https://bit.ly/2rtrl5l");
    Account jack = new Account("Jack", "This is a status", "https://bit.ly/2sQF6vh");
    Account troy = new Account("Troy", "Gluten free", "https://bit.ly/33Y7hFH");
    Account kelly = new Account("Kelly", "McDonald is a lovely place", "https://bit.ly/2sQF6vh");
    Account linda = new Account("Linda", "I am vegan", "https://bit.ly/2rtrl5l");
    Account kobe = new Account("Koke", "$$$", "https://bit.ly/2sbZDdi");
    fb.add(mike);
    fb.add(mel);
    fb.add(jack);
    fb.add(troy);
    fb.add(kelly);
    fb.add(linda);
    fb.add(kobe);
    fb.addFriend(mike, linda);
    fb.addFriend(mike, jack);
    fb.addFriend(mike, troy);
    fb.addFriend(mike, kobe);
    fb.addFriend(linda, troy);
    fb.addFriend(kobe, jack);
    fb.addFriend(jack, troy);
    fb.remove(linda);
    fb.printProfile(mike);
    mike.showFriends();
    fb.printProfile(linda);
    linda.showFriends();
    fb.printProfile(jack);
    jack.showFriends();
    fb.printProfile(troy);
    troy.showFriends();
    fb.printProfile(kelly);
    kelly.showFriends();
    fb.printProfile(kobe);
    kobe.showFriends();
    System.out.println("Linda is being remove from the network.");
    fb.remove(linda);
    System.out.println("Linda had been removed from the network.");
    fb.search("linda");
    mike.modifyName("KFC");
    mike.modifyStatus("Updated status");
    mike.modifyImage("Modified image");
    System.out.print("\n------------------------------\n");
    fb.search("KFC");
  }
}
