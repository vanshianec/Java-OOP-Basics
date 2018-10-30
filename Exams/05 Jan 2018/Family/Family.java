package Family;
import Colonist.Colonist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Family {
    private List<Colonist> colonists;

    private String id;

    public Family(String id){
        this.id = id;
        this.colonists = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void addColonist(Colonist colonist){
        colonists.add(colonist);
    }
    public int getSize(){
        return colonists.size();
    }

    public void removeColonist(String id){
        colonists.removeIf(colonist -> colonist.getId().equals(id));
    }

    public void grow(int years){
        for (Colonist colonist : colonists) {
            colonist.grow(years);
        }
    }
    public List<Colonist> getColonists(){
        return Collections.unmodifiableList(colonists);
    }

}
