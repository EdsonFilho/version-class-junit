import com.edsoncarmo.example.Version;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class VersionTest {

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void nullArgument() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage("version must not be null!");
        new Version(null);
    }

    @Test
    public void emptyArgument() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage("version must not be empty!");
        new Version("");
    }

    @Test
    public void illegalArgument() {
        exceptionRule.expect(IllegalArgumentException.class);
        exceptionRule.expectMessage("version must match: 'major.minor.patch(-SNAPSHOT)'!");
        new Version("3.0.0-");
    }

    @Test
    public void isSnapshotArgument() {
        Version v = new Version("3.0.0-SNAPSHOT");
        Assert.assertEquals("Version should be SNAPSHOT", true, v.isSnapshot());
    }

    @Test
    public void snapshotArgument() {
        Version v = new Version("3.0.0");
        Assert.assertEquals("Version should not be SNAPSHOT",false, v.isSnapshot());
    }

    @Test
    public void greaterThan() {
        Version v1 = new Version("3.2.0");
        Version v2 = new Version("3.2.1");
        Assert.assertEquals("3.2.1 should be greater than 3.2.0", true, v1.compareTo(v2) < 0);
    }

    @Test
    public void minorThan() {
        Version v1 = new Version("3.2.1");
        Version v2 = new Version("3.2.0");
        Assert.assertEquals("3.2.0 should be smaller than 3.2.1",false, v1.compareTo(v2) < 0);
    }

    @Test
    public void equal() {
        Version v1 = new Version("3.2.0");
        Version v2 = new Version("3.2.0");
        Assert.assertEquals("3.2.0 should be equal than 3.2.0", true, v1.compareTo(v2) == 0);
    }

    @Test
    public void greaterThanSnapshot() {
        Version v1 = new Version("3.2.0-SNAPSHOT");
        Version v2 = new Version("3.2.0");
        Assert.assertEquals("3.2.0 should be greater than 3.2.0-SNAPSHOT",true, v1.compareTo(v2) < 0);
    }

    @Test
    public void minorThanSnapshot() {
        Version v1 = new Version("3.2.0");
        Version v2 = new Version("3.2.0-SNAPSHOT");
        Assert.assertEquals("3.2.0 should be smaller than 3.2.0-SNAPSHOT",false, v1.compareTo(v2) < 0);
    }

    @Test
    public void equalThanSnapshot() {
        Version v1 = new Version("3.2.0-SNAPSHOT");
        Version v2 = new Version("3.2.0-SNAPSHOT");
        Assert.assertEquals("3.2.0-SNAPSHOT should be equals than 3.2.0-SNAPSHOT",true, v1.compareTo(v2) == 0);
    }
}
