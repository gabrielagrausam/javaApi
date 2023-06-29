package com.postgres.postgresnew;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
@Transactional
public class BeautyController {

    @Autowired
    private BeautyRepository beautyRepository;

    @GetMapping("/getBeauties")
    public List<Beauty> getAllBeauties(){
        return beautyRepository.findAll();
    }

    @PostMapping("/postBeauties")
    public Beauty createBeauty(@RequestBody Beauty beauty) {
        return beautyRepository.save(beauty);
    }

    @GetMapping("/getBeauties/{id}")
    public ResponseEntity<Beauty> getBeautyById(@PathVariable Long id) {
        Beauty beauty = beautyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Beauty not exist with id :" + id));
        return ResponseEntity.ok(beauty);
    }

    @PutMapping("/putBeauties/{id}")
    public ResponseEntity<Beauty> updateBeauty(@PathVariable Long id, @RequestBody Beauty beautyDetails) {
        Beauty beauty = beautyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Beauty does not exist with id: " + id));

        if (beautyDetails.getName() != null) {
            beauty.setName(beautyDetails.getName());
        }

        if (beautyDetails.getDescription() != null) {
            beauty.setDescription(beautyDetails.getDescription());
        }

        if (beautyDetails.getUses() != null) {
            beauty.setUses(beautyDetails.getUses());
        }

        Beauty updatedBeauty = beautyRepository.save(beauty);
        return ResponseEntity.ok(updatedBeauty);
    }

    @DeleteMapping("/deleteBeauties/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteBeauty(@PathVariable Long id){
        Beauty beauty = beautyRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Beauty not exist with id :" + id));

        beautyRepository.delete(beauty);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}

