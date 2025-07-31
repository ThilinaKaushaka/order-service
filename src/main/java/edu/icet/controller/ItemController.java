package edu.icet.controller;

import edu.icet.model.dto.item.ItemDtoSave;
import edu.icet.model.dto.item.ItemDtoView;
import edu.icet.service.custom.ItemService;
import edu.icet.util.item.ItemCategory;
import edu.icet.util.item.box.BoxMaterial;
import edu.icet.util.item.box.BoxSize;
import edu.icet.util.item.chain.ChainClaspType;
import edu.icet.util.item.chain.ChainMaterial;
import edu.icet.util.item.chain.ChainStyle;
import edu.icet.util.item.contact_lens.ContactLensDuration;
import edu.icet.util.item.contact_lens.ContactLensMaterial;
import edu.icet.util.item.contact_lens.ContactLensType;
import edu.icet.util.item.contact_liquid.SolutionType;
import edu.icet.util.item.frame.FrameGender;
import edu.icet.util.item.frame.FrameMaterial;
import edu.icet.util.item.frame.FrameShape;
import edu.icet.util.item.lens.LensCoating;
import edu.icet.util.item.lens.LensFinished;
import edu.icet.util.item.lens.LensMaterial;
import edu.icet.util.item.lens.LensType;
import edu.icet.util.item.lens_cleaner.CleanerType;
import edu.icet.util.item.lens_cloth.LensClothMaterial;
import edu.icet.util.item.lens_cloth.LensClothSize;
import edu.icet.util.item.nail.NailMaterial;
import edu.icet.util.item.nail.NailThreadType;
import edu.icet.util.item.nail.NailUsage;
import edu.icet.util.item.nose_pad.NosePadMaterial;
import edu.icet.util.item.nose_pad.NosePadMountType;
import edu.icet.util.item.nose_pad.NosePadShape;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
@CrossOrigin(origins = "http://localhost:4200")
@RequiredArgsConstructor
public class ItemController {

    final ItemService itemService;

    @PostMapping("/add")
    void addItem(@RequestBody ItemDtoSave itemDtoSave){
        System.out.println(itemDtoSave);            
        itemService.addItem(itemDtoSave);

    }

    @GetMapping("/search-by-id")
    ItemDtoView searchItem(@RequestParam(name = "id")String id){
        return itemService.searchItem(id);
    }

    @PutMapping("/update")
    void updateItem(@RequestBody ItemDtoSave itemDtoSave){
        itemService.updateItem(itemDtoSave);
    }

    @GetMapping("/get-box")
    List<ItemDtoView> getBox(){
        return itemService.getAllBox();
    }

    @GetMapping("/get-chain")
    List<ItemDtoView> getChain(){
        return itemService.getAllChain();
    }

    @GetMapping("/get-contact-lens")
    List<ItemDtoView> getContactLens(){
        return itemService.getAllContactLens();
    }

    @GetMapping("/get-contact-lens-liquid")
    List<ItemDtoView> getContactLensLiquid(){
        return itemService.getAllContactLensLiquid();
    }

    @GetMapping("/get-frame")
    List<ItemDtoView> getFrame(){
        return itemService.getAllFrame();
    }

    @GetMapping("/get-lens-cleaner")
    List<ItemDtoView> getLensCleaner(){
        return itemService.getAllLensCleaner();
    }

    @GetMapping("/get-lens-cloth")
    List<ItemDtoView> getLensCloth(){
        return itemService.getAllLensCloth();
    }

    @GetMapping("/get-lens")
    List<ItemDtoView> getLens(){
        return itemService.getAllLens();
    }

    @GetMapping("/get-nail")
    List<ItemDtoView> getNails(){
        return itemService.getAllNail();
    }

    @GetMapping("/get-nose-pad")
    List<ItemDtoView> getNosePad(){
        return itemService.getAllNosePad();
    }

    @GetMapping("/get-item-category")
    ItemCategory[] getItemCategory(){
        return itemService.getItemCategory();
    }


    @GetMapping("/get-contact-lens-duration")
    ContactLensDuration [] getContactLensDuration(){
        return itemService.getContactLensDuration();
    }

    @GetMapping("/get-contact-lens-material")
    ContactLensMaterial [] getContactLensMaterial(){
        return itemService.getContactLensMaterial();
    }

    @GetMapping("/get-contact-lens-type")
    ContactLensType [] getContactLensType(){
        return itemService.getContactLensType();
    }



    @GetMapping("/get-frame-gender")
    FrameGender [] getFrameGender(){
        return itemService.getFrameGender();
    }

    @GetMapping("/get-frame-material")
    FrameMaterial [] getFrameMaterial(){
        return itemService.getframeMaterial();
    }

    @GetMapping("/get-frame-shape")
    FrameShape [] getFrameShape(){
        return itemService.getFrameShape();
    }



    @GetMapping("/get-lens-coating")
    LensCoating [] getLensCoating(){
        return itemService.getLensCoating();
    }

    @GetMapping("/get-lens-finished")
    LensFinished [] getLensFinished(){
        return itemService.getLensFinished();
    }

    @GetMapping("/get-lens-material")
    LensMaterial [] getLensMaterial(){
        return itemService.getLensMaterial();
    }

    @GetMapping("/get-lens-type")
    LensType [] getLensType(){
        return itemService.getLensType();
    }



    @GetMapping("/get-nose-pad-material")
    NosePadMaterial [] getNosePadMaterial(){
        return itemService.getNosePadMaterial();
    }

    @GetMapping("/get-nose-pad-mount-type")
    NosePadMountType[] getNosePadMountType(){
        return itemService.getNosePadMountType();
    }

    @GetMapping("/get-nose-pad-shape")
    NosePadShape[] getNosePadShape(){
        return itemService.getNosePadShape();
    }



    @GetMapping("/get-solution-type")
    SolutionType[] getSolutionType(){
        return itemService.getSolutionType();
    }


    @GetMapping("/get-cleaner-type")
    CleanerType [] getLensCleanerType(){
        return itemService.getCleanerType();
    }



    @GetMapping("/get-lens-cloth-material")
    LensClothMaterial[] getLensClothMaterial(){
        return itemService.getLensClothMaterial();
    }

    @GetMapping("/get-lens-cloth-size")
    LensClothSize[] getLensClothSize(){
        return itemService.getLensClothSize();
    }



    @GetMapping("/get-box-material")
    BoxMaterial[] getBoxMaterial(){
        return itemService.getBoxMaterial();
    }

    @GetMapping("/get-box-size")
    BoxSize[] getBoxSize(){
        return itemService.getBoxSize();
    }



    @GetMapping("/get-nail-material")
    NailMaterial [] getNailMaterial(){
        return itemService.getNailMaterial();
    }

    @GetMapping("/get-nail-thread-type")
    NailThreadType[] getNailThreadType(){
        return itemService.getNailThreadType();
    }

    @GetMapping("/get-nail-usage")
    NailUsage[] getNailUsage(){
        return itemService.getNailUsage();
    }


    @GetMapping("/get-chain-clasp-type")
    ChainClaspType[] getChainClaspType(){
        return itemService.getChainClaspType();
    }

    @GetMapping("/get-chain-material")
    ChainMaterial[] getChainMaterial(){
        return itemService.getChainMaterial();
    }

    @GetMapping("/get-chain-style")
    ChainStyle[] getChainStyle(){
        return itemService.getChainStyle();
    }






}
