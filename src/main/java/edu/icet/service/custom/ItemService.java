package edu.icet.service.custom;

import edu.icet.model.dto.item.ItemDtoSave;
import edu.icet.model.dto.item.ItemDtoView;
import edu.icet.service.SuperService;
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

import java.util.List;


public interface ItemService extends SuperService {
    void addItem(ItemDtoSave itemDtoSave);
    ItemDtoView searchItem(String search);
    void updateItem(ItemDtoSave itemDtoSave);

    List<ItemDtoView> getAllBox();
    List<ItemDtoView> getAllChain();
    List<ItemDtoView> getAllContactLens();
    List<ItemDtoView> getAllContactLensLiquid();
    List<ItemDtoView> getAllFrame();
    List<ItemDtoView> getAllLensCleaner();
    List<ItemDtoView> getAllLensCloth();
    List<ItemDtoView> getAllLens();
    List<ItemDtoView> getAllNail();
    List<ItemDtoView> getAllNosePad();

    ItemCategory [] getItemCategory();

    ContactLensDuration [] getContactLensDuration();
    ContactLensMaterial [] getContactLensMaterial();
    ContactLensType [] getContactLensType();

    FrameGender [] getFrameGender();
    FrameMaterial [] getframeMaterial();
    FrameShape [] getFrameShape();

    LensCoating [] getLensCoating();
    LensMaterial [] getLensMaterial();
    LensType [] getLensType();
    LensFinished [] getLensFinished();

    NosePadMaterial [] getNosePadMaterial();
    NosePadMountType [] getNosePadMountType();
    NosePadShape [] getNosePadShape();

    SolutionType [] getSolutionType();

    CleanerType [] getCleanerType();

    LensClothSize [] getLensClothSize();
    LensClothMaterial [] getLensClothMaterial();

    BoxMaterial [] getBoxMaterial();
    BoxSize [] getBoxSize();

    NailMaterial [] getNailMaterial();
    NailThreadType [] getNailThreadType();
    NailUsage [] getNailUsage();

    ChainClaspType [] getChainClaspType();
    ChainMaterial [] getChainMaterial();
    ChainStyle [] getChainStyle();

}
