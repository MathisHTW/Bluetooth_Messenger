package test.controller.logic.CRUD;

import org.junit.Assert;
import org.junit.Test;

import main.controller.logic.CRUD.Read;

public class TestRead {

    @Test
    public void defaultSizeOfChannelIsOne() {
        final Read read = new Read();
        Assert.assertEquals(1, read.getChannels().size());
    }



}
