package service;

import dto.MockDemoDto;

public class MockDemoService {

    private MockDemoDto demoDao;

    public MockDemoService(MockDemoDto demoDao) {
        this.demoDao = demoDao;
    }

    public int getDemoStatus(){
        System.out.println("getDemoStatus Through MockDemoService :");
        return demoDao.getDemoStatus();
    }

}
