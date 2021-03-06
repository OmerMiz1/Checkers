package main.logic;

public class TurkishBuilder extends ClassicBuilder {
    @Override
    public void buildLogic() {
        super.logic = new Turkish();
    }
}
