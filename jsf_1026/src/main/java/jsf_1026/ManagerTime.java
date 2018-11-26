package jsf_1026;

import java.time.LocalTime;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "managerTime")
@RequestScoped
public class ManagerTime {

	public LocalTime getTime() {
		return LocalTime.now();
	}
}
