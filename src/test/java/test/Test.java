package test;

import io.material.color.quantize.QuantizerCelebi;
import io.material.color.scheme.Scheme;
import io.material.color.score.Score;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) throws Exception {
        final BufferedImage img = ImageIO.read(Test.class.getResourceAsStream("/test.jpg"));
        final int width = img.getWidth(), height = img.getHeight();

        Map<Integer, Integer> colors = QuantizerCelebi.quantize(img.getRGB(0, 0, width, height, null, 0, width), 256);
        int color = Score.score(colors).get(0);

//        for (Map.Entry<Integer, Integer> col : colors.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toList())) {
//            System.out.println(rgbToString(col.getKey()) + " -> " + col.getValue());
//        }

        // theme color
        System.out.println(rgbToString(color));

        // color scheme
        final Scheme schemeLight = Scheme.light(color);
        final Scheme schemeLightContent = Scheme.lightContent(color);
        final Scheme schemeDark = Scheme.dark(color);
        final Scheme schemeDarkContent = Scheme.darkContent(color);

        System.out.println("### LIGHT ###");
        System.out.println(schemeToString(schemeLight));
        System.out.println("### LIGHT CONTENT ###");
        System.out.println(schemeToString(schemeLightContent));
        System.out.println("### DARK ###");
        System.out.println(schemeToString(schemeDark));
        System.out.println("### DARK CONTENT ###");
        System.out.println(schemeToString(schemeDarkContent));
    }

    private static String rgbToString(final int hex) {
        int alpha = hex >> 24 & 0xFF;
        int red = hex >> 16 & 0xFF;
        int green = hex >> 8 & 0xFF;
        int blue = hex & 0xFF;
        return "#" + String.format("%02x", red) + String.format("%02x", green) + String.format("%02x", blue) + (alpha != 255 ? String.format("%02x", alpha) : "");
    }

    private static String schemeToString(final Scheme scheme) {
        return " primary="
                + rgbToString(scheme.getPrimary())
                + ",\n onPrimary="
                + rgbToString(scheme.getOnPrimary())
                + ",\n primaryContainer="
                + rgbToString(scheme.getPrimaryContainer())
                + ",\n onPrimaryContainer="
                + rgbToString(scheme.getOnPrimaryContainer())
                + ",\n secondary="
                + rgbToString(scheme.getSecondary())
                + ",\n onSecondary="
                + rgbToString(scheme.getOnSecondary())
                + ",\n secondaryContainer="
                + rgbToString(scheme.getSecondaryContainer())
                + ",\n onSecondaryContainer="
                + rgbToString(scheme.getOnSecondaryContainer())
                + ",\n tertiary="
                + rgbToString(scheme.getTertiary())
                + ",\n onTertiary="
                + rgbToString(scheme.getOnTertiary())
                + ",\n tertiaryContainer="
                + rgbToString(scheme.getTertiaryContainer())
                + ",\n onTertiaryContainer="
                + rgbToString(scheme.getOnTertiaryContainer())
                + ",\n error="
                + rgbToString(scheme.getError())
                + ",\n onError="
                + rgbToString(scheme.getOnError())
                + ",\n errorContainer="
                + rgbToString(scheme.getErrorContainer())
                + ",\n onErrorContainer="
                + rgbToString(scheme.getOnErrorContainer())
                + ",\n background="
                + rgbToString(scheme.getBackground())
                + ",\n onBackground="
                + rgbToString(scheme.getOnBackground())
                + ",\n surface="
                + rgbToString(scheme.getSurface())
                + ",\n onSurface="
                + rgbToString(scheme.getOnSurface())
                + ",\n surfaceVariant="
                + rgbToString(scheme.getSurfaceVariant())
                + ",\n onSurfaceVariant="
                + rgbToString(scheme.getOnSurfaceVariant())
                + ",\n outline="
                + rgbToString(scheme.getOutline())
                + ",\n outlineVariant="
                + rgbToString(scheme.getOutlineVariant())
                + ",\n shadow="
                + rgbToString(scheme.getShadow())
                + ",\n scrim="
                + rgbToString(scheme.getScrim())
                + ",\n inverseSurface="
                + rgbToString(scheme.getInverseSurface())
                + ",\n inverseOnSurface="
                + rgbToString(scheme.getInverseOnSurface())
                + ",\n inversePrimary="
                + rgbToString(scheme.getInversePrimary());
    }
}
