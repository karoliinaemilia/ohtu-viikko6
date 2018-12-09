
package statistics;

import java.util.ArrayList;
import java.util.List;
import statistics.matcher.All;
import statistics.matcher.And;
import statistics.matcher.HasAtLeast;
import statistics.matcher.HasFewerThan;
import statistics.matcher.Matcher;
import statistics.matcher.Or;
import statistics.matcher.PlaysIn;

public class QueryBuilder {
    
    private List<Matcher> matchers;

    public QueryBuilder() {
        matchers = new ArrayList();
    }           
    
    QueryBuilder playsIn(String team) {
        matchers.add(new PlaysIn(team));
        return this;
    }
    
    QueryBuilder hasAtLeast(int value, String category) {
        matchers.add(new HasAtLeast(value, category));
        return this;
    }
    
    QueryBuilder hasFewerThan(int value, String category) {
        matchers.add(new HasFewerThan(value, category));
        return this;
    }
    
    public Matcher build() {
        if (matchers.isEmpty()) {
            return new All();
        }
        Matcher[] m = new Matcher[matchers.size()];
        for (int i = 0; i< matchers.size(); i++) {
            m[i] = matchers.get(i);
        }
        matchers.clear();
        return new And(m);
    }
    
    QueryBuilder oneOf(Matcher m1, Matcher m2) {
        matchers.add(new Or(m1, m2));
        return this;
    }
}
