package com.kodilla.patterns2.adapter.company.newhrsystem;

import com.kodilla.patterns2.adapter.company.oldhrsystem.Workers;
import org.junit.Test;

import static org.junit.Assert.*;

public class SalaryAdapterTest {
    @Test
    public void testTotalSalary() {
        //Given
        Workers workers = new Workers();
        SalaryAdapter salaryAdapter = new SalaryAdapter();
        //When
        double totalSalary = salaryAdapter.TotalSalary(workers.getWorkers(), workers.getSalaries());
        //Then
        System.out.println(totalSalary);
        assertEquals(totalSalary, 27750, 0);
    }

}