# JGLI

Java porting of the [g-truc GLI](https://github.com/g-truc/gli)

Every format listed [here](https://github.com/elect86/jgli/blob/master/Jgli/src/jgli/Format.java#L15) is supposed to be supported unless where differently specified [here](https://github.com/elect86/jgli/blob/master/Jgli/src/test/Main.java#L107-L281)

## Release notes

- Added support for many new formats
- Added texture swizzle support #51
- Fixed PVRTC2
- Fixed BPTC enum names
- Added TARGET_RECT and TARGET_RECT_ARRAY texture target support
- Fixed DXGI_FORMAT_B8G8R8X8_UNORM_SRGB support #59
- Fixed FORMAT_RGBA8_UNORM DDS loading using DDPF_RGBA mode #60

#### [JGLI 0.7.0.0](https://github.com/elect86/jgli/releases/tag/0.7.0.0) - 2015-10-09

- first true ported version 
- added support for DDS and KTX texture formats


