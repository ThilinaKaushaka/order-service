package edu.icet.service.custom.impl;

import edu.icet.model.dto.item.ItemDtoSave;
import edu.icet.model.dto.item.ItemDtoView;
import edu.icet.model.dto.item.box.BoxDto;
import edu.icet.model.dto.item.chain.ChainDto;
import edu.icet.model.dto.item.contact_lens.ContactLensDto;
import edu.icet.model.dto.item.contact_liquid.ContactLiquidDto;
import edu.icet.model.dto.item.frame.FrameDto;
import edu.icet.model.dto.item.lens.LensDto;
import edu.icet.model.dto.item.lens_cleaner.LensCleanerDto;
import edu.icet.model.dto.item.lens_cloth.LensClothDto;
import edu.icet.model.dto.item.nail.NailDto;
import edu.icet.model.dto.item.nose_pad.NosePadDto;
import edu.icet.model.entity.item.ItemEntity;
import edu.icet.model.entity.item.box.BoxEntity;
import edu.icet.model.entity.item.chain.ChainEntity;
import edu.icet.model.entity.item.contact_lens.ContactLensEntity;
import edu.icet.model.entity.item.contact_liquid.ContactLiquidEntity;
import edu.icet.model.entity.item.frame.FrameEntity;
import edu.icet.model.entity.item.lens.LensEntity;
import edu.icet.model.entity.item.lens_cleaner.LensCleanerEntity;
import edu.icet.model.entity.item.lens_cloth.LensClothEntity;
import edu.icet.model.entity.item.nail.NailEntity;
import edu.icet.model.entity.item.nose_pad.NosePadEntity;
import edu.icet.repository.custom.ItemDao;
import edu.icet.repository.custom.items.*;
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
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
    private final ItemDao itemDao;
    private final LensDao lensDao;
    private final FrameDao frameDao;
    private final ContactLensDao contactLensDao;
    private final ContactLiquidDao contactLiquidDao;
    private final LensCleanerDao lensCleanerDao;
    private final LensClothDao lensClothDao;
    private final BoxDao boxDao;
    private final NailDao nailDao;
    private final NosePadDao nosePadDao;
    private final ChainDao chainDao;
    private final ModelMapper mapper;

    @Override
    public void addItem(ItemDtoSave itemDtoSave) {
        saveItem(ItemEntity.builder().id(itemDtoSave.getId()).name(itemDtoSave.getName()).category(itemDtoSave.getCategory()).brand(itemDtoSave.getBrand()).qty(itemDtoSave.getQty()).price(itemDtoSave.getPrice()).description(itemDtoSave.getDescription()).isDisable(itemDtoSave.getIsDisable()).build());
        switch (itemDtoSave.getCategory()){
            case LENS: saveLens(itemDtoSave);return;
            case FRAME: saveFrame(itemDtoSave);return;
            case CONTACT_LENS: saveContactLens(itemDtoSave);return;
            case CONTACT_LIQUID: saveContactLiquid(itemDtoSave);return;
            case LENS_CLEANER: saveLensCleaner(itemDtoSave);return;
            case LENS_CLOTH: saveLensCloth(itemDtoSave);return;
            case BOX: saveBox(itemDtoSave);return;
            case NAIL: saveNail(itemDtoSave);return;
            case NOSE_PAD: saveNosePad(itemDtoSave);return;
            case CHAIN: saveChain(itemDtoSave);
        }
    }

    private void saveItem(ItemEntity itemEntity){
        itemDao.save(itemEntity);
    }

    private void saveLens(ItemDtoSave itemDtoSave){
        LensEntity lens=mapper.map(itemDtoSave.getItemObject(), LensEntity.class);
        lens.setItemEntity(ItemEntity.builder().id(itemDtoSave.getId()==null?itemDao.findLastId():itemDtoSave.getId()).build());
        lensDao.save(lens);
    }

    private void saveFrame(ItemDtoSave itemDtoSave){
        FrameEntity frame=mapper.map(itemDtoSave.getItemObject(), FrameEntity.class);
        frame.setItemEntity(ItemEntity.builder().id(itemDtoSave.getId()==null?itemDao.findLastId():itemDtoSave.getId()).build());
        frameDao.save(frame);
    }

    private void saveContactLens(ItemDtoSave itemDtoSave){
        ContactLensEntity contactLens=mapper.map(itemDtoSave.getItemObject(), ContactLensEntity.class);
        contactLens.setItemEntity(ItemEntity.builder().id(itemDtoSave.getId()==null?itemDao.findLastId():itemDtoSave.getId()).build());
        contactLensDao.save(contactLens);
    }

    private void saveContactLiquid(ItemDtoSave itemDtoSave){
        ContactLiquidEntity contactLiquid=mapper.map(itemDtoSave.getItemObject(), ContactLiquidEntity.class);
        contactLiquid.setItemEntity(ItemEntity.builder().id(itemDtoSave.getId()==null?itemDao.findLastId():itemDtoSave.getId()).build());
        contactLiquidDao.save(contactLiquid);
    }

    private void saveLensCleaner(ItemDtoSave itemDtoSave){
        LensCleanerEntity lensCleaner=mapper.map(itemDtoSave.getItemObject(), LensCleanerEntity.class);
        lensCleaner.setItemEntity(ItemEntity.builder().id(itemDtoSave.getId()==null?itemDao.findLastId():itemDtoSave.getId()).build());
        lensCleanerDao.save(lensCleaner);
    }

    private void saveLensCloth(ItemDtoSave itemDtoSave){
        LensClothEntity lensCloth=mapper.map(itemDtoSave.getItemObject(), LensClothEntity.class);
        lensCloth.setItemEntity(ItemEntity.builder().id(itemDtoSave.getId()==null?itemDao.findLastId():itemDtoSave.getId()).build());
        lensClothDao.save(lensCloth);
    }

    private void saveBox(ItemDtoSave itemDtoSave){
        BoxEntity box=mapper.map(itemDtoSave.getItemObject(), BoxEntity.class);
        box.setItemEntity(ItemEntity.builder().id(itemDtoSave.getId()==null?itemDao.findLastId():itemDtoSave.getId()).build());
        boxDao.save(box);
    }

    private void saveNail(ItemDtoSave itemDtoSave){
        NailEntity nail=mapper.map(itemDtoSave.getItemObject(), NailEntity.class);
        nail.setItemEntity(ItemEntity.builder().id(itemDtoSave.getId()==null?itemDao.findLastId():itemDtoSave.getId()).build());
        nailDao.save(nail);
    }

    private void saveNosePad(ItemDtoSave itemDtoSave){
        NosePadEntity nosePad=mapper.map(itemDtoSave.getItemObject(), NosePadEntity.class);
        nosePad.setItemEntity(ItemEntity.builder().id(itemDtoSave.getId()==null?itemDao.findLastId():itemDtoSave.getId()).build());
        nosePadDao.save(nosePad);
    }

    private void saveChain(ItemDtoSave itemDtoSave){
        ChainEntity chain=mapper.map(itemDtoSave.getItemObject(), ChainEntity.class );
        chain.setItemEntity(ItemEntity.builder().id(itemDtoSave.getId()==null?itemDao.findLastId():itemDtoSave.getId()).build());
        chainDao.save(chain);

    }

    @Override
    public ItemDtoView searchItem(String search) {
        String [] array = search.toUpperCase().split("-");
        return switch (array[0]) {
            case "ITEM" -> searchItemByItemCode(Integer.parseInt(array[1]));
            case "L" -> searchByLensId(Integer.parseInt(array[1]));
            case "B" -> searchByBoxId(Integer.parseInt(array[1]));
            case "C" -> searchByChainId(Integer.parseInt(array[1]));
            case "CLL" -> searchByContactLensLiquidId(Integer.parseInt(array[1]));
            case "CL" -> searchByContactLens(Integer.parseInt(array[1]));
            case "F" -> searchByFrameId(Integer.parseInt(array[1]));
            case "LC" -> searchByLensCleanerId(Integer.parseInt(array[1]));
            case "LCL" -> searchByLensClothId(Integer.parseInt(array[1]));
            case "N" -> searchByNailId(Integer.parseInt(array[1]));
            case "NP" -> searchByNosePadId(Integer.parseInt(array[1]));
            default -> null;
        };
    }

    @Override
    public void updateItem(ItemDtoSave itemDtoSave) {
        addItem(itemDtoSave);
    }

    @Override
    public List<ItemDtoView> getAllBox() {
        List<ItemDtoView> list=new ArrayList<>();
        boxDao.findAll().forEach(boxEntity -> {
            ItemDtoView itemDtoView=getItemDtoView(boxEntity.getItemEntity().getId());
            itemDtoView.setItemObject(mapper.map(boxEntity, BoxDto.class));
            list.add(itemDtoView);
        });
        return list;
    }

    @Override
    public List<ItemDtoView> getAllChain() {
        List<ItemDtoView> list=new ArrayList<>();
        chainDao.findAll().forEach(entity -> {
            ItemDtoView itemDtoView=getItemDtoView(entity.getItemEntity().getId());
            itemDtoView.setItemObject(mapper.map(entity, ChainDto.class));
            list.add(itemDtoView);
        });
        return list;
    }

    @Override
    public List<ItemDtoView> getAllContactLens() {
        List<ItemDtoView> list=new ArrayList<>();
        contactLensDao.findAll().forEach(entity -> {
            ItemDtoView itemDtoView=getItemDtoView(entity.getItemEntity().getId());
            itemDtoView.setItemObject(mapper.map(entity, ContactLensDto.class));
            list.add(itemDtoView);
        });
        return list;
    }

    @Override
    public List<ItemDtoView> getAllContactLensLiquid() {
        List<ItemDtoView> list=new ArrayList<>();
        contactLiquidDao.findAll().forEach(entity -> {
            ItemDtoView itemDtoView=getItemDtoView(entity.getItemEntity().getId());
            itemDtoView.setItemObject(mapper.map(entity, ContactLiquidDto.class));
            list.add(itemDtoView);
        });
        return list;
    }

    @Override
    public List<ItemDtoView> getAllFrame() {
        List<ItemDtoView> list=new ArrayList<>();
        frameDao.findAll().forEach(entity -> {
            ItemDtoView itemDtoView=getItemDtoView(entity.getItemEntity().getId());
            itemDtoView.setItemObject(mapper.map(entity, FrameDto.class));
            list.add(itemDtoView);
        });
        return list;
    }

    @Override
    public List<ItemDtoView> getAllLensCleaner() {
        List<ItemDtoView> list=new ArrayList<>();
        lensCleanerDao.findAll().forEach(entity -> {
            ItemDtoView itemDtoView=getItemDtoView(entity.getItemEntity().getId());
            itemDtoView.setItemObject(mapper.map(entity, LensCleanerDto.class));
            list.add(itemDtoView);
        });
        return list;
    }

    @Override
    public List<ItemDtoView> getAllLensCloth() {
        List<ItemDtoView> list=new ArrayList<>();
        lensClothDao.findAll().forEach(entity -> {
            ItemDtoView itemDtoView=getItemDtoView(entity.getItemEntity().getId());
            itemDtoView.setItemObject(mapper.map(entity, LensClothDto.class));
            list.add(itemDtoView);
        });
        return list;
    }

    @Override
    public List<ItemDtoView> getAllLens() {
        List<ItemDtoView> list=new ArrayList<>();
        lensDao.findAll().forEach(entity -> {
            ItemDtoView itemDtoView=getItemDtoView(entity.getItemEntity().getId());
            itemDtoView.setItemObject(mapper.map(entity, LensDto.class));
            list.add(itemDtoView);
        });
        return list;
    }

    @Override
    public List<ItemDtoView> getAllNail() {
        List<ItemDtoView> list=new ArrayList<>();
        nailDao.findAll().forEach(entity -> {
            ItemDtoView itemDtoView=getItemDtoView(entity.getItemEntity().getId());
            itemDtoView.setItemObject(mapper.map(entity, NailDto.class));
            list.add(itemDtoView);
        });
        return list;
    }

    @Override
    public List<ItemDtoView> getAllNosePad() {
        List<ItemDtoView> list=new ArrayList<>();
        nosePadDao.findAll().forEach(entity -> {
            ItemDtoView itemDtoView=getItemDtoView(entity.getItemEntity().getId());
            itemDtoView.setItemObject(mapper.map(entity, NosePadDto.class));
            list.add(itemDtoView);
        });
        return list;
    }

    private ItemDtoView searchByNosePadId(Integer nosePadId) {
        NosePadDto nosePadDto= mapper.map(nosePadDao.findById(nosePadId), NosePadDto.class);
        ItemDtoView itemDtoView=getItemDtoView(nosePadDto.getItemId());
        itemDtoView.setItemObject(nosePadDto);
        return itemDtoView;
    }

    private ItemDtoView searchByNailId(Integer nailId) {
        NailDto nailDto= mapper.map(nailDao.findById(nailId), NailDto.class);
        ItemDtoView itemDtoView=getItemDtoView(nailDto.getItemId());
        itemDtoView.setItemObject(nailDto);
        return itemDtoView;
    }

    private ItemDtoView searchByLensClothId(Integer clothId) {
        LensClothDto lensClothDto= mapper.map(lensClothDao.findById(clothId), LensClothDto.class);
        ItemDtoView itemDtoView=getItemDtoView(lensClothDto.getItemId());
        itemDtoView.setItemObject(clothId);
        return itemDtoView;
    }

    private ItemDtoView searchByLensCleanerId(Integer cleanerId) {
        LensCleanerDto lensCleanerDto = mapper.map(lensCleanerDao.findById(cleanerId), LensCleanerDto.class);
        ItemDtoView itemDtoView=getItemDtoView(lensCleanerDto.getItemId());
        itemDtoView.setItemObject(lensCleanerDto);
        return itemDtoView;
    }

    private ItemDtoView searchByFrameId(Integer frameId) {
        FrameDto frameDto = mapper.map(frameDao.findById(frameId), FrameDto.class);
        ItemDtoView itemDtoView=getItemDtoView(frameDto.getItemId());
        itemDtoView.setItemObject(frameDto);
        return itemDtoView;
    }


    private ItemDtoView searchByContactLens(Integer contactLensId) {
        ContactLensDto contactLensDto = mapper.map(contactLensDao.findById(contactLensId), ContactLensDto.class);
        ItemDtoView itemDtoView=getItemDtoView(contactLensDto.getItemId());
        itemDtoView.setItemObject(contactLensDto);
        return itemDtoView;
    }

    private ItemDtoView searchByChainId(Integer chainId) {
        ChainDto chainDto=mapper.map(chainDao.findById(chainId), ChainDto.class);
        ItemDtoView itemDtoView=getItemDtoView(chainDto.getItemId());
        itemDtoView.setItemObject(chainDto);
        return itemDtoView;
    }
    private ItemDtoView searchByContactLensLiquidId(Integer contactLiquidId) {
        ContactLiquidDto contactLiquidDto=mapper.map(contactLiquidDao.findById(contactLiquidId), ContactLiquidDto.class);
        ItemDtoView itemDtoView=getItemDtoView(contactLiquidDto.getItemId());
        itemDtoView.setItemObject(contactLiquidDto);
        return itemDtoView;
    }
    private ItemDtoView searchByBoxId(Integer boxId) {
        BoxDto boxDto=mapper.map(boxDao.findById(boxId), BoxDto.class);
        ItemDtoView itemDtoView=getItemDtoView(boxDto.getItemId());
        itemDtoView.setItemObject(boxDto);
        return itemDtoView;
    }

    private ItemDtoView searchByLensId(Integer lensId) {
        LensDto lensDto = mapper.map(lensDao.findById(lensId), LensDto.class);
        ItemDtoView itemDtoView=getItemDtoView(lensDto.getItemId());
        itemDtoView.setItemObject(lensDto);
        return itemDtoView;
    }

    private ItemDtoView getItemDtoView(Integer itemId){
        ItemEntity itemEntity=getItemEntity(itemId);
        assert itemEntity!=null;
        return ItemDtoView.builder().id(itemEntity.getId()).brand(itemEntity.getBrand()).category(itemEntity.getCategory()).description(itemEntity.getDescription()).isDisable(itemEntity.getIsDisable()).name(itemEntity.getName()).price(itemEntity.getPrice()).qty(itemEntity.getQty()).build();
    }



    private ItemDtoView searchItemByItemCode(Integer itemId){
        ItemEntity itemEntity = getItemEntity(itemId);
        assert itemEntity != null;
        return ItemDtoView.builder().id(itemEntity.getId()).brand(itemEntity.getBrand()).category(itemEntity.getCategory()).description(itemEntity.getDescription()).isDisable(itemEntity.getIsDisable()).name(itemEntity.getName()).price(itemEntity.getPrice()).qty(itemEntity.getQty()).itemObject(searchByItemIdAndCategory(itemEntity.getCategory(),itemEntity.getId())).build();
    }

    private ItemEntity getItemEntity(Integer id){
        return itemDao.findById(id).orElse(null);
    }

    private Object searchByItemIdAndCategory(ItemCategory itemCategory,Integer itemId){
        return switch (itemCategory) {
            case LENS -> mapper.map( lensDao.findByItemId(itemId), LensDto.class);
            case FRAME -> mapper.map( frameDao.findByItemId(itemId), FrameDto.class);
            case CONTACT_LENS -> mapper.map( contactLensDao.findByItemId(itemId), ContactLensDto.class);
            case CONTACT_LIQUID -> mapper.map( contactLiquidDao.findByItemId(itemId), ContactLiquidDto.class);
            case LENS_CLEANER -> mapper.map( lensCleanerDao.findByItemId(itemId), LensCleanerDto.class);
            case LENS_CLOTH -> mapper.map( lensClothDao.findByItemId(itemId),LensClothDto.class);
            case BOX -> mapper.map( boxDao.findByItemId(itemId),BoxDto.class);
            case NAIL -> mapper.map( nailDao.findByItemId(itemId), NailDto.class);
            case NOSE_PAD -> mapper.map( nosePadDao.findByItemId(itemId), NosePadDto.class);
            case CHAIN -> mapper.map( chainDao.findByItemId(itemId), ChainDto.class);
        };
    }

    @Override
    public ItemCategory[] getItemCategory() {
        return ItemCategory.values();
    }

    @Override
    public ContactLensDuration[] getContactLensDuration() {
        return ContactLensDuration.values();
    }

    @Override
    public ContactLensMaterial[] getContactLensMaterial() {
        return ContactLensMaterial.values();
    }

    @Override
    public ContactLensType[] getContactLensType() {
        return ContactLensType.values();
    }



    @Override
    public FrameGender[] getFrameGender() {
        return FrameGender.values();
    }

    @Override
    public FrameMaterial[] getframeMaterial() {
        return FrameMaterial.values();
    }

    @Override
    public FrameShape[] getFrameShape() {
        return FrameShape.values();
    }



    @Override
    public LensCoating[] getLensCoating() {
        return LensCoating.values();
    }

    @Override
    public LensMaterial[] getLensMaterial() {
        return LensMaterial.values();
    }

    @Override
    public LensType[] getLensType() {
        return LensType.values();
    }

    @Override
    public LensFinished[] getLensFinished() {
        return LensFinished.values();
    }

    @Override
    public NosePadMaterial[] getNosePadMaterial() {
        return NosePadMaterial.values();
    }

    @Override
    public NosePadMountType[] getNosePadMountType() {
        return NosePadMountType.values();
    }

    @Override
    public NosePadShape[] getNosePadShape() {
        return NosePadShape.values();
    }

    @Override
    public SolutionType[] getSolutionType() {
        return SolutionType.values();
    }

    @Override
    public CleanerType[] getCleanerType() {
        return CleanerType.values();
    }

    @Override
    public LensClothSize[] getLensClothSize() {
        return LensClothSize.values();
    }

    @Override
    public LensClothMaterial[] getLensClothMaterial() {
        return LensClothMaterial.values();
    }

    @Override
    public BoxMaterial[] getBoxMaterial() {
        return BoxMaterial.values();
    }

    @Override
    public BoxSize[] getBoxSize() {
        return BoxSize.values();
    }



    @Override
    public NailMaterial[] getNailMaterial() {
        return NailMaterial.values();
    }

    @Override
    public NailThreadType[] getNailThreadType() {
        return NailThreadType.values();
    }

    @Override
    public NailUsage[] getNailUsage() {
        return NailUsage.values();
    }

    @Override
    public ChainClaspType[] getChainClaspType() {
        return ChainClaspType.values();
    }

    @Override
    public ChainMaterial[] getChainMaterial() {
        return ChainMaterial.values();
    }

    @Override
    public ChainStyle[] getChainStyle() {
        return ChainStyle.values();
    }
}
