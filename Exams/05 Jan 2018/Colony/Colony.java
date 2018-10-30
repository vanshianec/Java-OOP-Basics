package Colony;

import Colonist.Colonist;
import Family.Family;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class Colony {

    private int maxFamilyCount;
    private int maxFamilyCapacity;
    private List<Family> families;

    public Colony(int maxFamilyCount, int maxFamilyCapacity) {
        this.maxFamilyCount = maxFamilyCount;
        this.maxFamilyCapacity = maxFamilyCapacity;
        this.families = new ArrayList<>();
    }

    public int getMaxFamilyCount() {
        return maxFamilyCount;
    }

    public int getMaxFamilyCapacity() {
        return maxFamilyCapacity;
    }

    public List<Colonist> getColonistsByFamilyId(String familyId) {
        for (Family family : families) {
            if(family.getId().equals(familyId)){
                return Collections.unmodifiableList(family.getColonists());
            }
        }
        return null;
    }

    public boolean ContainsFamily(String id) {
        for (Family family : families) {
            if (family.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public void addColonist(Colonist colonist) {
        String familyId = colonist.getFamilyId();
        for (Family family : families) {
            if (family.getId().equals(familyId)) {
                if (family.getSize() >= maxFamilyCapacity) {
                    System.out.println("family is full");
                    return;
                }
                family.addColonist(colonist);
            }
        }
    }

    public void addFamily(Family family) {
        if (this.families.size() == maxFamilyCount) {
            throw new IllegalArgumentException("colony is full");
        }
        this.families.add(family);
    }

    public void removeColonist(String familyId, String memberId) {
        for (Family family : families) {
            if(family.getId().equals(familyId)){
                family.removeColonist(memberId);
            }
        }
        families.removeIf(family -> family.getId().equals(familyId) && family.getSize()==0);
    }

    public void removeFamily(String id) {
        families.removeIf(family -> family.getId().equals(id));
    }

    public void grow(int years) {
        for (Family family : families) {
            family.grow(years);
        }
    }

    public int getPotential() {
        int totalPotential = 0;
        for (Family family : families) {
            totalPotential+=family.getColonists().stream().mapToInt(colonist -> colonist.getPotential()).sum();
        }
        return totalPotential;
    }

    public String getCapacity() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("families: %d/%d",this.families.size(),this.maxFamilyCount)).append(System.lineSeparator());
        List<Family> sortedFamilies = this.families.stream().sorted((f1,f2) -> f1.getId().compareTo(f2.getId()))
                .collect(Collectors.toList());
        for (Family family : sortedFamilies) {
            sb.append(String.format("-%s: %d/%d",family.getId(),family.getSize(),this.maxFamilyCapacity))
                    .append(System.lineSeparator());
        }
        return sb.toString().trim();

    }

    public String getColonists(String familyId){
        List<Colonist> colonists = getColonistsByFamilyId(familyId);
        if(colonists==null){
            return "family does not exist";
        }
        colonists = colonists.stream().sorted((c1,c2) -> c1.getId().compareTo(c2.getId())).collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        sb.append(familyId).append(":").append(System.lineSeparator());
        for (Colonist colonist : colonists) {
             sb.append(String.format("-%s: %d",colonist.getId(),colonist.getPotential())).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }



}
