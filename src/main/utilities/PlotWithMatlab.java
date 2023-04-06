package main.utilities;

import com.mathworks.engine.EngineException;
import com.mathworks.engine.MatlabEngine;
import com.mathworks.engine.MatlabExecutionException;
import com.mathworks.engine.MatlabSyntaxException;

import java.util.concurrent.ExecutionException;

public class PlotWithMatlab {
    private static MatlabEngine eng;
    public static void plot(String x, String y) {
        try {
            eng = MatlabEngine.startMatlab();
            eng.eval(x);
            eng.eval(y);
            eng.eval("plot(x, y, '-o')");
            Thread.sleep(20000);
        } catch (EngineException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (MatlabExecutionException e) {
            throw new RuntimeException(e);
        } catch (MatlabSyntaxException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }
    }

}
