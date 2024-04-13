package newPack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.asserts.SoftAssert;

public class StreamsDemo {


		// TODO Auto-generated method stub
		public void streamFilter()
		{
			ArrayList<String> a = new ArrayList();
			a.add("Wilson");
			a.add("Negevn");
			a.add("Petern");
			a.add("Ram");
			a.add("Charles");

			ArrayList<String> b = new ArrayList();
			b.add("Entebbe");
			b.add("Dimitry");
			b.add("Mgobo");
			b.add("Salim");
			b.add("Raghav");

			//there's no life for intermediate operation if terminal op is not present
			//terminal operation will execute only if intermediate op returns true
			//map method to be used when the data received from filter method requires modification
			//terminal methods- count(), sort(), limit()
			long x = a.stream().filter(name->name.startsWith("W")).count();
			System.out.println(x);
			//a.stream().filter(s->s.length()>4).forEach(v->System.out.println(v));
			//a.stream().filter(s->s.length()>4).limit(2).forEach(v->System.out.println(v));
			//a.stream().filter(s->s.endsWith("n") ).map(v->v.toUpperCase()).forEach(v->System.out.println(v));
			a.stream().filter(s->s.startsWith("A") ).sorted().map(v->v.toUpperCase()).forEach(v->System.out.println(v));
			Stream<String> s = Stream.concat(a.stream(), b.stream());
			boolean f = s.anyMatch(n->n.equalsIgnoreCase("raghavv"));
			System.out.println(f);
			SoftAssert m = new SoftAssert();
			m.assertTrue(f);

		}

		public void streamCollector()
		{

			List<String>g =Stream.of("August","Adam","Alex","Aditya").filter(s->s.startsWith("A") ).sorted().map(v->v.toUpperCase()).collect(Collectors.toList());
		    g.forEach(s->System.out.println(s));
		}

		public void lectureAssignment()
		{
			List<Integer> numbers = Arrays.asList(1,2,1,4,2,4,5,2,67,8,54,3);
			Set<Integer> set = new HashSet();
			numbers.forEach(j-> set.add(j));
			set.forEach(o->System.out.println(o));
			System.out.println("-------Using stream and lambda expressions--------");
			numbers.stream().sorted().distinct().forEach(u->System.out.println(u));
		}

		public static void main(String[] args) {

			StreamsDemo s = new StreamsDemo();
			s.lectureAssignment();
		}



}
