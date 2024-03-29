package net.knightech.agent;

import net.knightech.agent.domain.beans.AgentBean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;


@RestController
@RequestMapping(path = "/v1")
public class AgentController {

    private final AgentServiceImpl agentService;

    public AgentController(AgentServiceImpl agentService) {
        this.agentService = agentService;
    }

    @GetMapping("/agents/{id}")
    public DeferredResult<ResponseEntity<?>>  getAgent(@PathVariable("id") String id) {

        DeferredResult<ResponseEntity<?>> output = new DeferredResult<>();

        agentService.getAgent(id, output);

        return output;
    }

    @PostMapping(path = "/agents")
    public DeferredResult<ResponseEntity<?>>  addAgent(@RequestBody AgentBean agent) {

        DeferredResult<ResponseEntity<?>> output = new DeferredResult<>();

        agentService.addAgent(agent, output);

        return output;

    }

}
