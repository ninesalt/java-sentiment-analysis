package sentiment;

import com.sun.jna.Structure;
import java.util.Arrays;
import java.util.List;

public class GoString extends Structure implements Structure.ByValue {

    public String p;
    public long n;
    protected List<String> getFieldOrder(){
        return Arrays.asList(new String[]{"p","n"});
    }

    public GoString(String i){
        super();
        this.p = i;
        this.n = i.length();
    }

}
