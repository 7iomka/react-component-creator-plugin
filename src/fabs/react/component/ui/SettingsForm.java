package fabs.react.component.ui;

import fabs.react.component.data.ComponentCreateOptions;
import fabs.util.AbstractSettingsForm;

import javax.swing.*;

public class SettingsForm extends AbstractSettingsForm<ComponentCreateOptions> {
    private JPanel mainPanel;
    private JTextField componentTemplateInput;
    private JTextField storyTemplateInput;
    private JTextField specTemplateInput;
    private JTextField scssTemplateInput;
    private JTextField mdTemplateInput;
    private JTextField indexTemplateInput;

    private JButton componentTemplateBtn;
    private JButton storyTemplateBtn;
    private JButton specTemplateBtn;
    private JButton scssTemplateBtn;
    private JButton mdTemplateBtn;
    private JButton indexTemplateBtn;

    private JButton componentTemplateResetBtn;
    private JButton storybookTemplateReset;
    private JButton specTemplateResetBtn;
    private JButton scssTemplateReset;
    private JButton mdTemplateResetBtn;
    private JButton indexTemplateResetBtn;

    private JCheckBox storybookCheckbox;
    private JCheckBox specCheckBox;
    private JCheckBox SCSSCheckBox;
    private JCheckBox mdCheckBox;
    private JCheckBox indexCheckBox;

    public SettingsForm(ComponentCreateOptions options) {
        super(options);

        if (!options.isComponentTemplateDefault()) {
            componentTemplateInput.setText(options.getComponentTemplateFile());
        }

        if (!options.isStoryTemplateDefault()) {
            storyTemplateInput.setText(options.getStoryTemplateFile());
        }

        if (!options.isSpecTemplateDefault()) {
            specTemplateInput.setText(options.getSpecTemplateFile());
        }

        if (!options.isSassTemplateDefault()) {
            scssTemplateInput.setText(options.getSassTemplateFile());
        }

        if (!options.isMDTemplateDefault()) {
            mdTemplateInput.setText(options.getMarkdownTemplateFile());
        }

        if (!options.isIndexTemplateDefault()) {
            indexTemplateInput.setText(options.getIndexTemplateFile());
        }

        storybookCheckbox.setSelected(options.isCreateStorybookDefaultChecked());
        specCheckBox.setSelected(options.isCreateSpecDefaultChecked());
        SCSSCheckBox.setSelected(options.isCreateScssDefaultChecked());
        mdCheckBox.setSelected(options.isCreateMarkdownDefaultChecked());
        indexCheckBox.setSelected(options.isCreateIndexDefaultChecked());

        componentTemplateBtn.addActionListener(e -> onBrowseButtonClicked(e, componentTemplateInput));
        componentTemplateResetBtn.addActionListener(e -> onResetButtonClicked(e, componentTemplateInput));

        storyTemplateBtn.addActionListener(e -> onBrowseButtonClicked(e, storyTemplateInput));
        storybookTemplateReset.addActionListener(e -> onResetButtonClicked(e, storyTemplateInput));

        specTemplateBtn.addActionListener(e -> onBrowseButtonClicked(e, specTemplateInput));
        specTemplateResetBtn.addActionListener(e -> onResetButtonClicked(e, specTemplateInput));

        scssTemplateBtn.addActionListener(e -> onBrowseButtonClicked(e, scssTemplateInput));
        scssTemplateReset.addActionListener(e -> onResetButtonClicked(e, scssTemplateInput));

        mdTemplateBtn.addActionListener(e -> onBrowseButtonClicked(e, mdTemplateInput));
        mdTemplateResetBtn.addActionListener(e -> onBrowseButtonClicked(e, mdTemplateInput));

        indexTemplateBtn.addActionListener(e -> onBrowseButtonClicked(e, indexTemplateInput));
        indexTemplateResetBtn.addActionListener(e -> onBrowseButtonClicked(e, indexTemplateInput));

    }

    @Override
    public JComponent getMainPanel() {
        return mainPanel;
    }

    @Override
    public boolean isDirty() {
        ComponentCreateOptions o = new ComponentCreateOptions();
        applySettings(o);
        return !options.equals(o);
    }

    public void applySettings(ComponentCreateOptions options) {
        String component = componentTemplateInput.getText();
        String story = storyTemplateInput.getText();
        String spec = specTemplateInput.getText();
        String scss = scssTemplateInput.getText();
        String md = mdTemplateInput.getText();
        String index = indexTemplateInput.getText();

        options.setComponentTemplateFile(component);
        options.setStoryTemplateFile(story);
        options.setSpecTemplateFile(spec);
        options.setSassTemplateFile(scss);
        options.setMarkdownTemplateFile(md);
        options.setIndexTemplateFile(index);

        options.setCreateIndexDefaultChecked(indexCheckBox.isSelected());
        options.setCreateMarkdownDefaultChecked(mdCheckBox.isSelected());
        options.setCreateSpecDefaultChecked(specCheckBox.isSelected());
        options.setCreateScssDefaultChecked(SCSSCheckBox.isSelected());
        options.setCreateStorybookDefaultChecked(storybookCheckbox.isSelected());
    }
}
