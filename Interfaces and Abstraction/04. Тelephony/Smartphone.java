import java.util.ArrayList;
import java.util.List;

public class Smartphone implements Callable,Browsable {

    private List<String> phoneNumbers;
    private List<String> browseLinks;

    Smartphone(){
        phoneNumbers = new ArrayList<>();
        browseLinks = new ArrayList<>();
    }

    public void addNumber(String phoneNumber){
        phoneNumbers.add(phoneNumber);
    }
    public void addLink(String browseLink){
        browseLinks.add(browseLink);
    }


    @Override
    public void browsing() {
        for (String browseLink : browseLinks) {
            if(browseLink.matches("\\D*")){
            System.out.println("Browsing: "+browseLink+"!");
            }
            else{
                System.out.println("Invalid URL!");
            }
        }
    }

    @Override
    public void calling() {
        for (String phoneNumber : phoneNumbers) {
            if(phoneNumber.matches("\\d*")){
                System.out.println("Calling... "+phoneNumber);
            }
            else {
                System.out.println("Invalid number!");
            }
        }
    }
}
