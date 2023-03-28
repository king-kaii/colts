package com.colt.scorecheck;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.colt.scorecheck.controller.ScoreCheckController;
import com.colt.scorecheck.service.ScoreCheckService;

@WebMvcTest(ScoreCheckController.class)
 class ScoreControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ScoreCheckService scoreService;

    

    @Test
    void testScoreCheck() throws Exception{
        

        String URI = "/scorecheck/score/13";

        Mockito.when(scoreService.checkScore(Mockito.any(Integer.class))).thenReturn(750);
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get(URI)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();

        String outputInJson = response.getContentAsString();

        assertTrue(outputInJson.equals("750"));
        assertEquals(HttpStatus.OK.value(), response.getStatus());

    }

   


}