import javax.swing.*;
import java.util.ArrayList;

public class CustomEspeList extends AbstractListModel {
    private ArrayList lista = personal.getPersonalList();
    @Override
    public int getSize() {
        return lista.size();
    }

    @Override
    public Object getElementAt(int index) {
        especialista espe = (especialista) lista.get(index);
        return espe.toString();
    }
    public void addEspe(especialista espe){
        lista.add(espe);
        this.fireIntervalAdded(this,getSize(),getSize()+1);
    }
    public especialista getPersona(int index){
        return (especialista) lista.get(index);
    }

}
