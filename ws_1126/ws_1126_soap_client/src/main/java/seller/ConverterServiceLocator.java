/**
 * ConverterServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package seller;

public class ConverterServiceLocator extends org.apache.axis.client.Service implements seller.ConverterService {

    public ConverterServiceLocator() {
    }


    public ConverterServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ConverterServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ConverterPort
    private java.lang.String ConverterPort_address = "http://localhost:4701/ws/converter";

    public java.lang.String getConverterPortAddress() {
        return ConverterPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ConverterPortWSDDServiceName = "ConverterPort";

    public java.lang.String getConverterPortWSDDServiceName() {
        return ConverterPortWSDDServiceName;
    }

    public void setConverterPortWSDDServiceName(java.lang.String name) {
        ConverterPortWSDDServiceName = name;
    }

    public seller.IConverter getConverterPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ConverterPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getConverterPort(endpoint);
    }

    public seller.IConverter getConverterPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            seller.ConverterPortBindingStub _stub = new seller.ConverterPortBindingStub(portAddress, this);
            _stub.setPortName(getConverterPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setConverterPortEndpointAddress(java.lang.String address) {
        ConverterPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (seller.IConverter.class.isAssignableFrom(serviceEndpointInterface)) {
                seller.ConverterPortBindingStub _stub = new seller.ConverterPortBindingStub(new java.net.URL(ConverterPort_address), this);
                _stub.setPortName(getConverterPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("ConverterPort".equals(inputPortName)) {
            return getConverterPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://seller/", "ConverterService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://seller/", "ConverterPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ConverterPort".equals(portName)) {
            setConverterPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
