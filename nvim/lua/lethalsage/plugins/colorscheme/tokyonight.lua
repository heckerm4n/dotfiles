-- return {
-- 	"folke/tokyonight.nvim",
-- 	config = function()
-- 		local tn = require("tokyonight")
-- 		-- local prompt = "#2d3149"
-- 		tn.setup({
-- 			style = "night",
-- 			transparent = true,
-- 			styles = {
-- 				-- Style to be applied to different syntax groups
-- 				-- Value is any valid attr-list value for `:help nvim_set_hl`
-- 				comments = { italic = true },
-- 				keywords = { italic = true },
-- 				functions = {},
-- 				variables = {},
-- 				-- Background styles. Can be "dark", "transparent" or "normal"
-- 				sidebars = "dark", -- style for sidebars, see below
-- 				floats = "dark", -- style for floating windows
-- 			},
-- 			on_highlights = function(hl, c)
-- 				-- hl.TelescopeNormal = {
-- 				--   bg = c.bg_dark,
-- 				--   fg = c.fg_dark,
-- 				-- }
-- 				-- hl.TelescopeBorder = {
-- 				--   bg = c.bg_dark,
-- 				--   fg = c.bg_dark,
-- 				-- }
-- 				-- hl.TelescopePromptNormal = {
-- 				--   bg = prompt,
-- 				-- }
-- 				-- hl.TelescopePromptBorder = {
-- 				--   bg = prompt,
-- 				--   fg = prompt,
-- 				-- }
-- 				-- hl.TelescopePromptTitle = {
-- 				--   bg = prompt,
-- 				--   fg = prompt,
-- 				-- }
-- 				-- hl.TelescopePreviewTitle = {
-- 				--   bg = c.bg_dark,
-- 				--   fg = c.bg_dark,
-- 				-- }
-- 				-- hl.TelescopeResultsTitle = {
-- 				--   bg = c.bg_dark,
-- 				--   fg = c.bg_dark,
-- 				-- }
-- 				hl.TelescopeNormal = { bg = "NONE" }
-- 				hl.TelescopeBorder = { bg = "NONE", fg = "#2d2e43" }
-- 				hl.TelescopePromptBorder = { bg = "NONE", fg = "#2d2e43" }
-- 				hl.TelescopeResultsBorder = { bg = "NONE", fg = "#2d2e43" }
-- 				hl.TelescopePreviewBorder = { bg = "NONE", fg = "#2d2e43" }
-- 			end,
-- 		})
--
-- 		-- vim.cmd [[highlight NormalFloat guibg=NONE]]
-- 		vim.cmd("colorscheme tokyonight")
-- 	end,
-- }

return {
  "folke/tokyonight.nvim",
  priority = 1000,
  config = function()
    local transparent = true -- set to true if you would like to enable transparency

    local bg = "#011628"
    local bg_dark = "#011423"
    local bg_highlight = "#143652"
    local bg_search = "#0A64AC"
    local bg_visual = "#275378"
    local fg = "#ABEED5" --"#CBE0F0"
    local fg_dark = "#63E3B3" -- "#B4D0E9"
    local fg_gutter = "#627E97"
    local border = "#547998"

    require("tokyonight").setup({
      style = "night",
      transparent = transparent,
      styles = {
        sidebars = transparent and "transparent" or "dark",
        floats = transparent and "transparent" or "dark",
      },
      on_colors = function(colors)
        colors.bg = bg
        colors.bg_dark = transparent and colors.none or bg_dark
        colors.bg_float = transparent and colors.none or bg_dark
        colors.bg_highlight = bg_highlight
        colors.bg_popup = bg_dark
        colors.bg_search = bg_search
        colors.bg_sidebar = transparent and colors.none or bg_dark
        colors.bg_statusline = transparent and colors.none or bg_dark
        colors.bg_visual = bg_visual
        colors.border = border
        colors.fg = fg
        colors.fg_dark = fg_dark
        colors.fg_float = fg
        colors.fg_gutter = fg_gutter
        colors.fg_sidebar = fg_dark
      end,
    })

    vim.cmd("colorscheme tokyonight")
  end,
}
