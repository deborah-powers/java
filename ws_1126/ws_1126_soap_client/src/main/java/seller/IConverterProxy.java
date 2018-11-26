package seller;

public class IConverterProxy implements seller.IConverter {
  private String _endpoint = null;
  private seller.IConverter iConverter = null;
  
  public IConverterProxy() {
    _initIConverterProxy();
  }
  
  public IConverterProxy(String endpoint) {
    _endpoint = endpoint;
    _initIConverterProxy();
  }
  
  private void _initIConverterProxy() {
    try {
      iConverter = (new seller.ConverterServiceLocator()).getConverterPort();
      if (iConverter != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)iConverter)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)iConverter)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (iConverter != null)
      ((javax.xml.rpc.Stub)iConverter)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public seller.IConverter getIConverter() {
    if (iConverter == null)
      _initIConverterProxy();
    return iConverter;
  }
  
  public double fToC(double arg0) throws java.rmi.RemoteException{
    if (iConverter == null)
      _initIConverterProxy();
    return iConverter.fToC(arg0);
  }
  
  public double cToF(double arg0) throws java.rmi.RemoteException{
    if (iConverter == null)
      _initIConverterProxy();
    return iConverter.cToF(arg0);
  }
  
  
}