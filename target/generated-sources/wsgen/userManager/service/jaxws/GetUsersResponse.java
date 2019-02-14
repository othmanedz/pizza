
package userManager.service.jaxws;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import userManager.service.User;

@XmlRootElement(name = "getUsersResponse", namespace = "http://service.userManager/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getUsersResponse", namespace = "http://service.userManager/")
public class GetUsersResponse {

    @XmlElement(name = "return", namespace = "")
    private List<User> _return;

    /**
     * 
     * @return
     *     returns List<User>
     */
    public List<User> getReturn() {
        return this._return;
    }

    /**
     * 
     * @param _return
     *     the value for the _return property
     */
    public void setReturn(List<User> _return) {
        this._return = _return;
    }

}
