import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FamilyTree {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Person> personsByName = new HashMap<>();
        HashMap<String, Person> personsByBirthday = new HashMap<>();

        String searchPersonKey = reader.readLine();
        boolean isName = Character.isLetter(searchPersonKey.charAt(0));

        String nameToNameRegex = "^(\\w+\\s+\\w+)\\s*-\\s*(\\w+\\s+\\w+)$";
        Pattern nameToNamePattern = Pattern.compile(nameToNameRegex);

        String nameToDateRegex = "^(\\w+\\s+\\w+)\\s*-\\s*(\\d{1,2}/\\d{1,2}/\\d{2,4})$";
        Pattern nameToDatePattern = Pattern.compile(nameToDateRegex);

        String dateToNameRegex = "^(\\d{1,2}/\\d{1,2}/\\d{2,4})\\s*-\\s*(\\w+\\s+\\w+)$";
        Pattern dateToNamePattern = Pattern.compile(dateToNameRegex);

        String dateToDateRegex = "^(\\d{1,2}/\\d{1,2}/\\d{2,4})\\s*-\\s*(\\d{1,2}/\\d{1,2}/\\d{2,4})$";
        Pattern dateToDatePattern = Pattern.compile(dateToDateRegex);

        String tiePersonInfoRegex = "^(\\w+\\s+\\w+)\\s+(\\d{1,2}/\\d{1,2}/\\d{2,4})$";
        Pattern tiePersonInfoPattern = Pattern.compile(tiePersonInfoRegex);

        int linesCounter = 0;

        while (true) {
            String input = reader.readLine();
            if ("End".equals(input)) {
                break;
            }

            linesCounter++;

            Matcher nameToNameMatcher = nameToNamePattern.matcher(input);
            Matcher nameToDateMatcher = nameToDatePattern.matcher(input);
            Matcher dateToNameMatcher = dateToNamePattern.matcher(input);
            Matcher dateToDateMatcher = dateToDatePattern.matcher(input);
            Matcher tiePersonInfoMatcher = tiePersonInfoPattern.matcher(input);

            if (nameToNameMatcher.find()) {
                String parentName = nameToNameMatcher.group(1);
                if (!personsByName.containsKey(parentName)) {
                    personsByName.put(parentName, new Person(parentName));
                }

                String childName = nameToNameMatcher.group(2);
                if (!personsByName.containsKey(childName)) {
                    personsByName.put(childName, new Person(childName));
                }

                Person parent = personsByName.get(parentName);
                Person child = personsByName.get(childName);

                parent.addChild(linesCounter, child);
                child.addParent(linesCounter, parent);
            }

            if (nameToDateMatcher.find()) {
                String parentName = nameToDateMatcher.group(1);
                if (!personsByName.containsKey(parentName)) {
                    personsByName.put(parentName, new Person(parentName));
                }

                String childBirthday = nameToDateMatcher.group(2);
                LocalDate childBirthDate = LocalDate.parse(childBirthday, Person.BIRTH_DATE_FORMATTER);
                if (!personsByBirthday.containsKey(childBirthday)) {
                    personsByBirthday.put(childBirthday, new Person(childBirthDate));
                }

                Person parent = personsByName.get(parentName);
                Person child = personsByBirthday.get(childBirthday);

                parent.addChild(linesCounter, child);
                child.addParent(linesCounter, parent);
            }

            if (dateToNameMatcher.find()) {
                String parentBirthday = dateToNameMatcher.group(1);
                LocalDate parentBirthDate = LocalDate.parse(parentBirthday, Person.BIRTH_DATE_FORMATTER);

                if (!personsByBirthday.containsKey(parentBirthday)) {
                    personsByBirthday.put(parentBirthday, new Person(parentBirthDate));
                }

                String childName = dateToNameMatcher.group(2);
                if (!personsByName.containsKey(childName)) {
                    personsByName.put(childName, new Person(childName));
                }

                Person parent = personsByBirthday.get(parentBirthday);
                Person child = personsByName.get(childName);

                parent.addChild(linesCounter, child);
                child.addParent(linesCounter, parent);
            }

            if (dateToDateMatcher.find()) {
                String parentBirthday = dateToDateMatcher.group(1);
                LocalDate parentBirthDate = LocalDate.parse(parentBirthday, Person.BIRTH_DATE_FORMATTER);

                if (!personsByBirthday.containsKey(parentBirthday)) {
                    personsByBirthday.put(parentBirthday, new Person(parentBirthDate));
                }

                String childBirthday = dateToDateMatcher.group(2);
                LocalDate childBirthDate = LocalDate.parse(childBirthday, Person.BIRTH_DATE_FORMATTER);

                if (!personsByBirthday.containsKey(childBirthday)) {
                    personsByBirthday.put(childBirthday, new Person(childBirthDate));
                }

                Person parent = personsByBirthday.get(parentBirthday);
                Person child = personsByBirthday.get(childBirthday);

                parent.addChild(linesCounter, child);
                child.addParent(linesCounter, parent);
            }

            if (tiePersonInfoMatcher.find()) {
                String personName = tiePersonInfoMatcher.group(1);
                String personBirthday = tiePersonInfoMatcher.group(2);
                LocalDate personBirthDate = LocalDate.parse(personBirthday, Person.BIRTH_DATE_FORMATTER);

                if (!personsByName.containsKey(personName)
                        && !personsByBirthday.containsKey(personBirthday)) {

                    Person person = new Person(personName, personBirthDate);
                    personsByName.put(personName, person);
                    personsByBirthday.put(personBirthday, person);
                } else if (personsByName.containsKey(personName)
                        && personsByBirthday.containsKey(personBirthday)) {

                    Person personByName = personsByName.get(personName);
                    Person personByBirthday = personsByBirthday.get(personBirthday);

                    personByName.setBirthDate(personBirthDate);
                    personByBirthday.setName(personName);

                    personByName.addParents(personByBirthday.getParents());
                    personByName.addChildren(personByBirthday.getChildren());

                    personByBirthday.addParents(personByName.getParents());
                    personByBirthday.addChildren(personByName.getChildren());
                } else if (personsByName.containsKey(personName)) {
                    Person person = personsByName.get(personName);
                    person.setBirthDate(personBirthDate);

                    personsByBirthday.put(personBirthday, person);
                } else {
                    Person person = personsByBirthday.get(personBirthday);
                    person.setName(personName);

                    personsByName.put(personName, person);
                }
            }
        }

        if (isName) {
            Person searchPerson = personsByName.get(searchPersonKey);
            System.out.println(searchPerson);
        } else {
            Person searchPerson = personsByBirthday.get(searchPersonKey);
            System.out.println(searchPerson);
        }
    }
}

class Person {
    public static final DateTimeFormatter BIRTH_DATE_FORMATTER = DateTimeFormatter.ofPattern("d/M/uuuu");

    private String name;
    private LocalDate birthDate;
    private TreeMap<Integer, Person> parents;
    private TreeMap<Integer, Person> children;

    public Person(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.parents = new TreeMap<>();
        this.children = new TreeMap<>();
    }

    public Person(String name) {
        this.name = name;
        this.parents = new TreeMap<>();
        this.children = new TreeMap<>();
    }

    public Person(LocalDate birthDate) {
        this.birthDate = birthDate;
        this.parents = new TreeMap<>();
        this.children = new TreeMap<>();
    }

    public String getName() { 
        return this.name; }

    public void setName(String name) { 
        this.name = name; }

    public void setBirthDate(LocalDate birthDate) { 
        this.birthDate = birthDate; }

    public Map<Integer, Person> getParents() {
        return this.parents;
    }

    public Map<Integer, Person> getChildren() {
        return this.children;
    }

    public void addChild(Integer appearanceIndex, Person child) {
        this.children.put(appearanceIndex, child);
    }

    public void addParent(Integer appearanceIndex, Person parent) {
        this.parents.put(appearanceIndex, parent);
    }

    public void addChildren(Map<Integer, Person> children) {
        this.children.putAll(children);
    }
    
    public void addParents(Map<Integer, Person> parents) {
        this.parents.putAll(parents);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(getNameAndBirthday(this));
        result.append("Parents:\n");
        for (Person person : this.parents.values()) {
            result.append(getNameAndBirthday(person));
        }
        result.append("Children:\n");
        for (Person kid : this.children.values()) {
            result.append(getNameAndBirthday(kid));
        }

        return result.toString();
    }

    private String getNameAndBirthday(Person person) {
        return String.format("%s %s%n",
                person.name,
                person.birthDate.format(BIRTH_DATE_FORMATTER));
    }
}
//bad practice just for testing purpose