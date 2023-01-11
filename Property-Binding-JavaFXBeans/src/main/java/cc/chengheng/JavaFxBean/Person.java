package cc.chengheng.JavaFxBean;


import java.beans.*;

public class Person {
    private String name;
    private String address;
    private String phoneNumber;


    private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    private final VetoableChangeSupport vetoableChangeSupport = new VetoableChangeSupport(this);



    public Person() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        String oldAddress = this.address;
        this.address = address;
        propertyChangeSupport.firePropertyChange("address", oldAddress, this.address);
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) throws PropertyVetoException {
        String oldPhoneNumber = this.phoneNumber;
        this.phoneNumber = phoneNumber;
        propertyChangeSupport.firePropertyChange("phoneNumber", oldPhoneNumber, this.phoneNumber);


        vetoableChangeSupport.fireVetoableChange("phoneNumber", oldPhoneNumber, phoneNumber);
    }

    public void addPropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        propertyChangeSupport.removePropertyChangeListener(l);
    }

    public PropertyChangeListener[] getPropertyChangeListeners() {
        return propertyChangeSupport.getPropertyChangeListeners();
    }

    public void addVetoableChangeListener(VetoableChangeListener l) {
        vetoableChangeSupport.addVetoableChangeListener(l);
    }

    public void removeVetoableChangeListener(VetoableChangeListener l) {
        vetoableChangeSupport.removeVetoableChangeListener(l);
    }

    public VetoableChangeListener[] getVetoableChangeListeners() {
        return vetoableChangeSupport.getVetoableChangeListeners();
    }
}