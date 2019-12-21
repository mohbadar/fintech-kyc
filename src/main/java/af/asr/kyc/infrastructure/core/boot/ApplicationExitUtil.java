package af.asr.kyc.infrastructure.core.boot;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.ConfigurableApplicationContext;

public abstract class ApplicationExitUtil {

    private ApplicationExitUtil() {}

    public static void waitForKeyPressToCleanlyExit(ConfigurableApplicationContext ctx) throws IOException {

        // NOTE: In Eclipse, the Shutdown Hooks are not invoked on exit (red
        // button).. In the case of MariaDB4j that's a problem because then the
        // mysqld won't be stopped, so:
        // (@see https://bugs.eclipse.org/bugs/show_bug.cgi?id=38016)
        System.out.println("\nHit Enter to quit...");
        // NOTE: In Eclipse, System.console() is not available.. so:
        // (@see https://bugs.eclipse.org/bugs/show_bug.cgi?id=122429)
        BufferedReader d = new BufferedReader(new InputStreamReader(System.in));
        d.readLine();

        ctx.stop();
        ctx.close();
    }
}