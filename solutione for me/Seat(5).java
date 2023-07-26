
/*
Anan alian
1211529
 */
public class Seat {

    private String seatNumber;
    private String passengerName;


    public Seat(String seatNumber) {
        this.seatNumber = seatNumber;
    }
    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;

    }

    public String getPassengerName() {
        return passengerName;
    }

    public boolean setPassengerName(String passengerName) {
        this.passengerName = passengerName;
        return false;
    }


    //in this function to check if the seat is valid or not
    public static boolean isValid (String seatnumber){
        String [] result = seatnumber.split(":");
        int x= Integer.parseInt(result[0].substring(1));
        if (result[0].charAt(0)=='A'){
            return x >= 1 && x <= 12;
        }else if(result[0].charAt(0)=='B'){
            return x >= 4 && x <= 12;
        }else if(result[0].charAt(0)=='C'){
            return x >= 1 && x <= 12;
        }else if(result[0].charAt(0)=='D'){
            return x >= 4 && x <= 12;
        }
        return false;
    }

        public static int getRow (String seatNumber){
        if(isValid(seatNumber)){
            int r = Integer.parseInt(seatNumber.substring(1));
            return (r-1);
        }
        else
            return -1;
    }

    static public int getColumn(String seatNumber){
        if(isValid(seatNumber)){
            char c = seatNumber.charAt(0);
            if (c=='A'){
                return 0;
            }
            if (c=='B'){
                return 1;
            }
            if (c=='C'){
                if(getRow(seatNumber)<=2) {
                    return 1;
                }
                else {
                    return 2;
                }
            }
            if (c=='D'){
                return 3;
            }
        }
        return 0;
    }

    // in this function  to check if the seat is empty or not
    public  boolean isEmpty (){
            if(getPassengerName()==null){
                //seat is empty
                return true;
            }
           return false;
    }

    // Printing information about the seat
    @Override
    public String toString() {
        return (seatNumber+ ": " +passengerName);
    }
}
