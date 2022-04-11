#include "Color.h"

#include <stdexcept>

	Color::Color(int red, int green, int blue) : 
		_red{red}, _green{green}, _blue{blue}, _reset{false} {
			if(red > 255 || red < 0 || green > 255 || green < 0 || blue > 255 || blue < 0) {
				throw std::invalid_argument("color out of bounds [0, 255]");
			}
		}

	Color::Color() : _red{0}, _green{0}, _blue{0}, _reset{true} { }

	std::string Color::to_string() {
		if(!_reset) {
			std::ostringstream format;
			format << "(" << _red << "," << _green << "," << _blue << ")";
			return format.str();
		} else {
			return "(reset)";
		}
	}

	std::string Color::colorize(std::string text) {
		if(!_reset) {
			std::ostringstream format;
			format << "\033[38;2;" << _red << ";" << _green << ";" << _blue << "m" << text << "\033[0m";
			return format.str();
		} else {
			return text;
		}
	}

	std::ostream& operator << (std::ostream& ost, const Color& color) {
		if(!color._reset) {
			ost << "\033[38;2;" << color._red << ";" << color._green << ";" << color._blue << "m";
			return ost;
		} else {
			ost << "\033[0m";
			return ost;
		}
	}

	Color operator + (const Color& color1, const Color& color2) {
		int _red = color1._red + color2._red;
		int _green = color1._green + color2._green;
		int _blue = color1._blue + color2._blue;

		return Color{_red, _green, _blue};
	}

	Color operator + (const Color& color, const int adjust) {
		int _red = color._red + adjust;
		int _green = color._green + adjust;
		int _blue = color._blue + adjust;

		if(_red > 255) {
			_red = 255;
		}
		if(_green > 255) {
			_green = 255;
		}
		if(_blue > 255) {
			_blue = 255;
		}

		return Color{_red, _green, _blue};
	}

	Color operator - (const Color& color, const int adjust) {
		int _red = color._red - adjust;
		int _green = color._green - adjust;
		int _blue = color._blue - adjust;

		if(_red < 0) {
			_red = 0;
		}
		if(_green < 0) {
			_green = 0;
		}
		if(_blue < 0) {
			_blue = 0;
		}

		return Color{_red, _green, _blue};
	}

	const Color Color::RESET{};
	const Color Color::BLACK{0, 0, 0};
	const Color Color::BLUE{0, 0, 255};
	const Color Color::GREEN{0, 255, 0};
	const Color Color::CYAN{0, 255, 255};
	const Color Color::RED{255, 0, 0};
	const Color Color::MAGENTA{255, 0, 0};
	const Color Color::YELLOW{255, 211, 0};
	const Color Color::GREY{128, 128, 128};
	const Color Color::WHITE{255, 255, 255};















