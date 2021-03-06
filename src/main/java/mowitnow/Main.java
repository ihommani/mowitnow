package mowitnow;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.google.common.collect.Lists;

import mowitnow.enums.Movement;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

/**
 * Main routine from mowitnow package. Initiate a field and two mowers to mow
 * the field
 * 
 * @author ihommani
 */
public class Main {
	public static void main(String[] args) throws FileNotFoundException,
			IOException {

		ApplicationContext appContext = new ClassPathXmlApplicationContext("application-context.xml");

		DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory(appContext);
		Resource directivesFile = appContext.getResource("directives.txt");

		if (directivesFile.exists()) {
			List<Tondeuse> tondeuses = Lists.newArrayList(
					(Tondeuse) beanFactory.getBean("tondeuse1"),
					(Tondeuse) beanFactory.getBean("tondeuse2"));

			FileReader directives = new FileReader(directivesFile.getFile());
			BufferedReader br = new BufferedReader(directives);

			String line;
			int lastIndex = 0;
			while ((line = br.readLine()) != null) {
				Tondeuse currentTondeuse = tondeuses.get(lastIndex);
				for (char c : line.toCharArray()) {
					currentTondeuse
							.move(Movement.valueOf(Character.toString(c)));
				}
				currentTondeuse.finalPosition(); // Print the final position
				currentTondeuse = null; // Small pimp, for we do not need the
										// mower anymore.
				lastIndex++;
			}
			br.close();
		}
	}
}
