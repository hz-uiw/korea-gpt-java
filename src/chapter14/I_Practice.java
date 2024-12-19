package chapter14;

// 직원 관리 시스템

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// 직원 목록 필터링 & 정렬
@AllArgsConstructor
@Getter
@ToString
class Employee {
    private String department;
    private String name;
    private double salary;
}
public class I_Practice {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("IT", "권민창", 5000),
                new Employee("HR", "정현영", 7000),
                new Employee("IT", "김민성", 1000),
                new Employee("Finance", "백가민", 5000),
                new Employee("HR", "김혜원", 6000)
        );
        // 1. 급여가 6000 이상인 직원 필터링
        List<Employee> employeeSalary = employees.stream()
                .filter(employee -> employee.getSalary() >= 6000)
                .collect(Collectors.toList());
        System.out.println("급여가 6000 이상인 직원 목록");
        employeeSalary.forEach(System.out::println);
//        급여가 6000 이상인 직원
//        Employee(department=HR, name=정현영, salary=7000.0)
//        Employee(department=HR, name=김혜원, salary=6000.0)

        // 1-1 급여가 5000 이하인 직원 필터링
        List<Employee> lessEmployeeSalary = employees.stream()
                .filter(employee -> employee.getSalary() <= 5000)
                .collect(Collectors.toList());
        System.out.println("\n급여가 5000 이하인 직원 목록");
        lessEmployeeSalary.forEach(System.out::println);
//        급여가 5000 이하인 직원 목록
//        Employee(department=IT, name=권민창, salary=5000.0)
//        Employee(department=IT, name=김민성, salary=1000.0)
//        Employee(department=Finance, name=백가민, salary=5000.0)

        // 2. IT 부서 직원의 이름만 추출
        List<String> employeeNames = employees.stream()
                // .filter(employee -> employee.getDepartment().equals("IT"))
                .filter(employee -> "IT".equals(employee.getDepartment()))
                .map(Employee::getName)
                .collect(Collectors.toList());
        System.out.println("\nIT 부서 직원 이름 목록");
        employeeNames.forEach(System.out::println);
//        IT 부서 직원 이름 목록
//        권민창
//        김민성

        // 3. 특정 부서(HR) 직원 중 이름에 '김'이 포함된 직원 필터링
        List<Employee> employeesWithKim = employees.stream()
                .filter(employee -> employee.getDepartment().equals("HR"))
                .filter(employee -> employee.getName().contains("김"))
                .collect(Collectors.toList());
        System.out.println("\nHR부서 직원 중 이름에 '김'이 포함된 직원 목록");
        employeesWithKim.forEach(System.out::println);
//        HR부서 직원 중 이름에 '김'이 포함된 직원 목록
//        Employee(department=HR, name=김혜원, salary=6000.0)

        // 4. 부서별 직원 그룹화
        Map<String, List<Employee>> employeeByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println("\n부서별 직원 그룹화");
        System.out.println(employeeByDept);
        // 부서별 직원 그룹화
        // {Finance=[Employee(department=Finance, name=백가민, salary=5000.0)],
        // HR=[Employee(department=HR, name=정현영, salary=7000.0), Employee(department=HR, name=김혜원, salary=6000.0)],
        // IT=[Employee(department=IT, name=권민창, salary=5000.0), Employee(department=IT, name=김민성, salary=1000.0)]}


        // 5. 부서별 평균 급여 계산
        Map<String, Double> avgSalaryByDept1 = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)));
//        Map<String, Double> avgSalaryByDept2 = employees.stream()
//                .collect(Collectors.groupingBy(employee -> employee.getDepartment(),
//                        Collectors.averagingDouble(employee -> employee.getSalary())));
        System.out.println(avgSalaryByDept1);
//        System.out.println(avgSalaryByDept2);
        System.out.println("\n부서별 평균 급여");
        // 부서별 평균 급여
        // {Finance=5000.0, HR=6500.0, IT=3000.0}
    }
}
